package no.fintlabs.consumer.model.fastlonn;

import no.fintlabs.core.consumer.shared.resource.kafka.EventKafkaProducer;
import no.fintlabs.kafka.event.EventProducerFactory;
import no.fintlabs.kafka.event.topic.EventTopicService;
import org.springframework.stereotype.Service;

@Service
public class FastlonnEventKafkaProducer extends EventKafkaProducer {
    public FastlonnEventKafkaProducer(EventProducerFactory eventProducerFactory, FastlonnConfig fastlonnConfig, EventTopicService eventTopicService) {
        super(eventProducerFactory, fastlonnConfig, eventTopicService);
    }
}
