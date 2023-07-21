package no.fintlabs.consumer.model.fravar;

import no.fintlabs.core.consumer.shared.resource.kafka.EventKafkaProducer;
import no.fintlabs.kafka.event.EventProducerFactory;
import no.fintlabs.kafka.event.topic.EventTopicService;
import org.springframework.stereotype.Service;

@Service
public class FravarEventKafkaProducer extends EventKafkaProducer {
    public FravarEventKafkaProducer(EventProducerFactory eventProducerFactory, FravarConfig fravarConfig, EventTopicService eventTopicService) {
        super(eventProducerFactory, fravarConfig, eventTopicService);
    }
}
