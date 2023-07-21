package no.fintlabs.consumer.model.arbeidsforhold;

import lombok.extern.slf4j.Slf4j;
import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.resource.administrasjon.personal.ArbeidsforholdResource;
import no.fintlabs.cache.Cache;
import no.fintlabs.cache.CacheManager;
import no.fintlabs.cache.packing.PackingTypes;
import no.fintlabs.core.consumer.shared.resource.CacheService;
import no.fintlabs.core.consumer.shared.resource.ConsumerConfig;
import no.fintlabs.core.consumer.shared.resource.kafka.EntityKafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Slf4j
@Service
public class ArbeidsforholdService extends CacheService<ArbeidsforholdResource> {

    private final EntityKafkaConsumer<ArbeidsforholdResource> entityKafkaConsumer;

    private final ArbeidsforholdLinker linker;

    private final ArbeidsforholdResponseKafkaConsumer arbeidsforholdResponseKafkaConsumer;

    public ArbeidsforholdService(
            ArbeidsforholdConfig consumerConfig,
            CacheManager cacheManager,
            ArbeidsforholdEntityKafkaConsumer entityKafkaConsumer,
            ArbeidsforholdLinker linker, ArbeidsforholdResponseKafkaConsumer arbeidsforholdResponseKafkaConsumer) {
        super(consumerConfig, cacheManager, entityKafkaConsumer);
        this.entityKafkaConsumer = entityKafkaConsumer;
        this.linker = linker;
        this.arbeidsforholdResponseKafkaConsumer = arbeidsforholdResponseKafkaConsumer;
    }

    @Override
    protected Cache<ArbeidsforholdResource> initializeCache(CacheManager cacheManager, ConsumerConfig<ArbeidsforholdResource> consumerConfig, String s) {
        return cacheManager.create(PackingTypes.POJO, consumerConfig.getOrgId(), consumerConfig.getResourceName());
    }

    @PostConstruct
    private void registerKafkaListener() {
        long retention = entityKafkaConsumer.registerListener(ArbeidsforholdResource.class, this::addResourceToCache);
        getCache().setRetentionPeriodInMs(retention);
    }

    private void addResourceToCache(ConsumerRecord<String, ArbeidsforholdResource> consumerRecord) {
        this.eventLogger.logDataRecieved();
        ArbeidsforholdResource resource = consumerRecord.value();
        if (resource == null) {
            getCache().remove(consumerRecord.key());
        } else {
            linker.mapLinks(resource);
            this.getCache().put(consumerRecord.key(), resource, linker.hashCodes(resource));
            if (consumerRecord.headers().lastHeader("event-corr-id") != null){
                String corrId = new String(consumerRecord.headers().lastHeader("event-corr-id").value(), StandardCharsets.UTF_8);
                log.debug("Adding corrId to EntityResponseCache: {}", corrId);
                arbeidsforholdResponseKafkaConsumer.getEntityCache().add(corrId, resource);
            }
        }
    }

    @Override
    public Optional<ArbeidsforholdResource> getBySystemId(String systemId) {
        return getCache().getLastUpdatedByFilter(systemId.hashCode(),
                (resource) -> Optional
                        .ofNullable(resource)
                        .map(ArbeidsforholdResource::getSystemId)
                        .map(Identifikator::getIdentifikatorverdi)
                        .map(systemId::equals)
                        .orElse(false)
        );
    }
}
