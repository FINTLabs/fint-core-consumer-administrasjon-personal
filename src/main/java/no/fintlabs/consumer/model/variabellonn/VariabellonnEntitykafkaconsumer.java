package no.fintlabs.consumer.model.variabellonn;

import no.fint.model.resource.administrasjon.personal.VariabellonnResource;
import no.fintlabs.core.consumer.shared.resource.kafka.EntityKafkaConsumer;
import no.fintlabs.kafka.common.ListenerBeanRegistrationService;
import no.fintlabs.kafka.entity.EntityConsumerFactoryService;
import no.fintlabs.kafka.entity.topic.EntityTopicService;
import org.springframework.stereotype.Service;

@Service
public class VariabellonnEntityKafkaConsumer extends EntityKafkaConsumer<VariabellonnResource> {

    public VariabellonnEntityKafkaConsumer(
            EntityConsumerFactoryService entityConsumerFactoryService,
            ListenerBeanRegistrationService listenerBeanRegistrationService,
            EntityTopicService entityTopicService,
            VariabellonnConfig variabellonnConfig) {
        super(entityConsumerFactoryService, listenerBeanRegistrationService, entityTopicService, variabellonnConfig);
    }
}
