package no.fintlabs.consumer.model.personalmappe;

import no.fintlabs.core.consumer.shared.resource.kafka.EventKafkaProducer;
import no.fintlabs.kafka.event.EventProducerFactory;
import no.fintlabs.kafka.event.topic.EventTopicService;
import org.springframework.stereotype.Service;

@Service
public class PersonalmappeEventKafkaProducer extends EventKafkaProducer {
    public PersonalmappeEventKafkaProducer(EventProducerFactory eventProducerFactory, PersonalmappeConfig personalmappeConfig, EventTopicService eventTopicService) {
        super(eventProducerFactory, personalmappeConfig, eventTopicService);
    }
}
