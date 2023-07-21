package no.fintlabs.consumer.model.fastlonn;

import no.fint.model.resource.administrasjon.personal.FastlonnResource;
import no.fintlabs.core.consumer.shared.resource.kafka.EntityKafkaConsumer;
import no.fintlabs.kafka.common.ListenerBeanRegistrationService;
import no.fintlabs.kafka.entity.EntityConsumerFactoryService;
import no.fintlabs.kafka.entity.topic.EntityTopicService;
import org.springframework.stereotype.Service;

@Service
public class FastlonnEntityKafkaConsumer extends EntityKafkaConsumer<FastlonnResource> {

    public FastlonnEntityKafkaConsumer(
            EntityConsumerFactoryService entityConsumerFactoryService,
            ListenerBeanRegistrationService listenerBeanRegistrationService,
            EntityTopicService entityTopicService,
            FastlonnConfig fastlonnConfig) {
        super(entityConsumerFactoryService, listenerBeanRegistrationService, entityTopicService, fastlonnConfig);
    }
}
