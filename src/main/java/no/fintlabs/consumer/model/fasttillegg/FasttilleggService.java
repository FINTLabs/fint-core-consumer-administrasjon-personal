package no.fintlabs.consumer.model.fasttillegg;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.resource.administrasjon.personal.FasttilleggResource;
import no.fintlabs.cache.Cache;
import no.fintlabs.cache.CacheManager;
import no.fintlabs.cache.packing.PackingTypes;
import no.fintlabs.core.consumer.shared.resource.CacheService;
import no.fintlabs.core.consumer.shared.resource.ConsumerConfig;
import no.fintlabs.core.consumer.shared.resource.kafka.EntityKafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Slf4j
@Service
public class FasttilleggService extends CacheService<FasttilleggResource> {

    private final EntityKafkaConsumer<FasttilleggResource> entityKafkaConsumer;

    private final FasttilleggLinker linker;

    private final FasttilleggResponseKafkaConsumer fasttilleggResponseKafkaConsumer;

    public FasttilleggService(
            FasttilleggConfig consumerConfig,
            CacheManager cacheManager,
            FasttilleggEntityKafkaConsumer entityKafkaConsumer,
            FasttilleggLinker linker, FasttilleggResponseKafkaConsumer fasttilleggResponseKafkaConsumer) {
        super(consumerConfig, cacheManager, entityKafkaConsumer);
        this.entityKafkaConsumer = entityKafkaConsumer;
        this.linker = linker;
        this.fasttilleggResponseKafkaConsumer = fasttilleggResponseKafkaConsumer;
    }

    @Override
    protected Cache<FasttilleggResource> initializeCache(CacheManager cacheManager, ConsumerConfig<FasttilleggResource> consumerConfig, String s) {
        return cacheManager.create(PackingTypes.POJO, consumerConfig.getOrgId(), consumerConfig.getResourceName());
    }

    @PostConstruct
    private void registerKafkaListener() {
        entityKafkaConsumer.registerListener(FasttilleggResource.class, this::addResourceToCache);
    }

    private void addResourceToCache(ConsumerRecord<String, FasttilleggResource> consumerRecord) {
        updateRetensionTime(consumerRecord.headers().lastHeader("topic-retension-time"));
        this.eventLogger.logDataRecieved();
        FasttilleggResource resource = consumerRecord.value();
        if (resource == null) {
            getCache().remove(consumerRecord.key());
        } else {
            linker.toResource(resource);
            this.getCache().put(consumerRecord.key(), resource, linker.hashCodes(resource));
            if (consumerRecord.headers().lastHeader("event-corr-id") != null){
                String corrId = new String(consumerRecord.headers().lastHeader("event-corr-id").value(), StandardCharsets.UTF_8);
                log.debug("Adding corrId to EntityResponseCache: {}", corrId);
                fasttilleggResponseKafkaConsumer.getEntityCache().add(corrId, resource);
            }
        }
    }

    @Override
    public Optional<FasttilleggResource> getBySystemId(String systemId) {
        return getCache().getLastUpdatedByFilter(systemId.hashCode(),
                (resource) -> Optional
                        .ofNullable(resource)
                        .map(FasttilleggResource::getSystemId)
                        .map(Identifikator::getIdentifikatorverdi)
                        .map(systemId::equals)
                        .orElse(false)
        );
    }
}
