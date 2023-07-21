package no.fintlabs.consumer.model.personalmappe;

import no.fint.model.resource.administrasjon.personal.PersonalmappeResource;
import no.fintlabs.core.consumer.shared.resource.kafka.EntityKafkaConsumer;
import no.fintlabs.kafka.common.ListenerBeanRegistrationService;
import no.fintlabs.kafka.entity.EntityConsumerFactoryService;
import no.fintlabs.kafka.entity.topic.EntityTopicService;
import org.springframework.stereotype.Service;

@Service
public class PersonalmappeEntityKafkaConsumer extends EntityKafkaConsumer<PersonalmappeResource> {

    public PersonalmappeEntityKafkaConsumer(
            EntityConsumerFactoryService entityConsumerFactoryService,
            ListenerBeanRegistrationService listenerBeanRegistrationService,
            EntityTopicService entityTopicService,
            PersonalmappeConfig personalmappeConfig) {
        super(entityConsumerFactoryService, listenerBeanRegistrationService, entityTopicService, personalmappeConfig);
    }
}
