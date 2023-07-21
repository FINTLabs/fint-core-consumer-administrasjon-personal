package no.fintlabs.consumer.model.variabellonn;

import no.fint.model.resource.administrasjon.personal.VariabellonnResource;
import no.fintlabs.core.consumer.shared.resource.event.EventResponseKafkaConsumer;
import no.fintlabs.kafka.event.EventConsumerFactoryService;
import org.springframework.stereotype.Service;

@Service
public class VariabellonnResponseKafkaConsumer extends EventResponseKafkaConsumer<VariabellonnResource> {

    public VariabellonnResponseKafkaConsumer(EventConsumerFactoryService eventConsumerFactoryService, VariabellonnConfig variabellonnConfig, VariabellonnLinker variabellonnLinker) {
        super(eventConsumerFactoryService, variabellonnConfig, variabellonnLinker);
    }

}
