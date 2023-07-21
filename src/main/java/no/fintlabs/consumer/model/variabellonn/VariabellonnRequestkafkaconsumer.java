package no.fintlabs.consumer.model.variabellonn;

import no.fint.model.resource.administrasjon.personal.VariabellonnResource;
import no.fintlabs.core.consumer.shared.resource.event.EventRequestKafkaConsumer;
import no.fintlabs.kafka.event.EventConsumerFactoryService;
import org.springframework.stereotype.Service;

@Service
public class VariabellonnRequestKafkaConsumer extends EventRequestKafkaConsumer<VariabellonnResource> {
    public VariabellonnRequestKafkaConsumer(EventConsumerFactoryService eventConsumerFactoryService, VariabellonnConfig variabellonnConfig) {
        super(eventConsumerFactoryService, variabellonnConfig);
    }
}
