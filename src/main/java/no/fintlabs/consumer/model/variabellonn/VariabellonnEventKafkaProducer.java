package no.fintlabs.consumer.model.variabellonn;

import no.fintlabs.core.consumer.shared.resource.kafka.EventKafkaProducer;
import no.fintlabs.kafka.event.EventProducerFactory;
import no.fintlabs.kafka.event.topic.EventTopicService;
import org.springframework.stereotype.Service;

@Service
public class VariabellonnEventKafkaProducer extends EventKafkaProducer {
    public VariabellonnEventKafkaProducer(EventProducerFactory eventProducerFactory, VariabellonnConfig variabellonnConfig, EventTopicService eventTopicService) {
        super(eventProducerFactory, variabellonnConfig, eventTopicService);
    }
}
