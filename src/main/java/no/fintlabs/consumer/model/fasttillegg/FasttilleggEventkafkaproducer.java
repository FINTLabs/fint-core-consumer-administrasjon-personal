package no.fintlabs.consumer.model.fasttillegg;

import no.fintlabs.core.consumer.shared.resource.kafka.EventKafkaProducer;
import no.fintlabs.kafka.event.EventProducerFactory;
import no.fintlabs.kafka.event.topic.EventTopicService;
import org.springframework.stereotype.Service;

@Service
public class FasttilleggEventKafkaProducer extends EventKafkaProducer {
    public FasttilleggEventKafkaProducer(EventProducerFactory eventProducerFactory, FasttilleggConfig fasttilleggConfig, EventTopicService eventTopicService) {
        super(eventProducerFactory, fasttilleggConfig, eventTopicService);
    }
}
