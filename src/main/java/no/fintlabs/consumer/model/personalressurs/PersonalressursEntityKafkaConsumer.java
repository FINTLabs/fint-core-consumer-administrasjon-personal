package no.fintlabs.consumer.model.personalressurs;

import no.fint.model.resource.administrasjon.personal.PersonalressursResource;
import no.fintlabs.core.consumer.shared.resource.kafka.EntityKafkaConsumer;
import no.fintlabs.kafka.common.ListenerBeanRegistrationService;
import no.fintlabs.kafka.entity.EntityConsumerFactoryService;
import no.fintlabs.kafka.entity.topic.EntityTopicService;
import org.springframework.stereotype.Service;

@Service
public class PersonalressursEntityKafkaConsumer extends EntityKafkaConsumer<PersonalressursResource> {

    public PersonalressursEntityKafkaConsumer(
            EntityConsumerFactoryService entityConsumerFactoryService,
            ListenerBeanRegistrationService listenerBeanRegistrationService,
            EntityTopicService entityTopicService,
            PersonalressursConfig personalressursConfig) {
        super(entityConsumerFactoryService, listenerBeanRegistrationService, entityTopicService, personalressursConfig);
    }
}
