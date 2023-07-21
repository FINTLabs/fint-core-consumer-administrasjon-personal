package no.fintlabs.consumer.model.personalmappe;

import lombok.extern.slf4j.Slf4j;
import no.fint.model.felles.kompleksedatatyper.Identifikator;
import no.fint.model.resource.administrasjon.personal.PersonalmappeResource;
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
public class PersonalmappeService extends CacheService<PersonalmappeResource> {

    private final EntityKafkaConsumer<PersonalmappeResource> entityKafkaConsumer;

    private final PersonalmappeLinker linker;

    private final PersonalmappeResponseKafkaConsumer personalmappeResponseKafkaConsumer;

    public PersonalmappeService(
            PersonalmappeConfig consumerConfig,
            CacheManager cacheManager,
            PersonalmappeEntityKafkaConsumer entityKafkaConsumer,
            PersonalmappeLinker linker, PersonalmappeResponseKafkaConsumer personalmappeResponseKafkaConsumer) {
        super(consumerConfig, cacheManager, entityKafkaConsumer);
        this.entityKafkaConsumer = entityKafkaConsumer;
        this.linker = linker;
        this.personalmappeResponseKafkaConsumer = personalmappeResponseKafkaConsumer;
    }

    @Override
    protected Cache<PersonalmappeResource> initializeCache(CacheManager cacheManager, ConsumerConfig<PersonalmappeResource> consumerConfig, String s) {
        return cacheManager.create(PackingTypes.POJO, consumerConfig.getOrgId(), consumerConfig.getResourceName());
    }

    @PostConstruct
    private void registerKafkaListener() {
        long retention = entityKafkaConsumer.registerListener(PersonalmappeResource.class, this::addResourceToCache);
        getCache().setRetentionPeriodInMs(retention);
    }

    private void addResourceToCache(ConsumerRecord<String, PersonalmappeResource> consumerRecord) {
        this.eventLogger.logDataRecieved();
        PersonalmappeResource resource = consumerRecord.value();
        if (resource == null) {
            getCache().remove(consumerRecord.key());
        } else {
            linker.mapLinks(resource);
            this.getCache().put(consumerRecord.key(), resource, linker.hashCodes(resource));
            if (consumerRecord.headers().lastHeader("event-corr-id") != null){
                String corrId = new String(consumerRecord.headers().lastHeader("event-corr-id").value(), StandardCharsets.UTF_8);
                log.debug("Adding corrId to EntityResponseCache: {}", corrId);
                personalmappeResponseKafkaConsumer.getEntityCache().add(corrId, resource);
            }
        }
    }

    @Override
    public Optional<PersonalmappeResource> getBySystemId(String systemId) {
        return getCache().getLastUpdatedByFilter(systemId.hashCode(),
                (resource) -> Optional
                        .ofNullable(resource)
                        .map(PersonalmappeResource::getSystemId)
                        .map(Identifikator::getIdentifikatorverdi)
                        .map(systemId::equals)
                        .orElse(false)
        );
    }
}
