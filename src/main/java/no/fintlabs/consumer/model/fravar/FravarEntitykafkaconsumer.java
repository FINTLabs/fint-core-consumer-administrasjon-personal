package no.fintlabs.consumer.model.fravar;

import no.fint.model.resource.administrasjon.personal.FravarResource;
import no.fintlabs.core.consumer.shared.resource.kafka.EntityKafkaConsumer;
import no.fintlabs.kafka.common.ListenerBeanRegistrationService;
import no.fintlabs.kafka.entity.EntityConsumerFactoryService;
import no.fintlabs.kafka.entity.topic.EntityTopicService;
import org.springframework.stereotype.Service;

@Service
public class FravarEntityKafkaConsumer extends EntityKafkaConsumer<FravarResource> {

    public FravarEntityKafkaConsumer(
            EntityConsumerFactoryService entityConsumerFactoryService,
            ListenerBeanRegistrationService listenerBeanRegistrationService,
            EntityTopicService entityTopicService,
            FravarConfig fravarConfig) {
        super(entityConsumerFactoryService, listenerBeanRegistrationService, entityTopicService, fravarConfig);
    }
}
