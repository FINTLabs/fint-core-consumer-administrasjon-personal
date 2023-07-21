package no.fintlabs.consumer.model.fasttillegg;

import no.fint.model.resource.administrasjon.personal.FasttilleggResource;
import no.fintlabs.core.consumer.shared.resource.kafka.EntityKafkaConsumer;
import no.fintlabs.kafka.common.ListenerBeanRegistrationService;
import no.fintlabs.kafka.entity.EntityConsumerFactoryService;
import no.fintlabs.kafka.entity.topic.EntityTopicService;
import org.springframework.stereotype.Service;

@Service
public class FasttilleggEntityKafkaConsumer extends EntityKafkaConsumer<FasttilleggResource> {

    public FasttilleggEntityKafkaConsumer(
            EntityConsumerFactoryService entityConsumerFactoryService,
            ListenerBeanRegistrationService listenerBeanRegistrationService,
            EntityTopicService entityTopicService,
            FasttilleggConfig fasttilleggConfig) {
        super(entityConsumerFactoryService, listenerBeanRegistrationService, entityTopicService, fasttilleggConfig);
    }
}
