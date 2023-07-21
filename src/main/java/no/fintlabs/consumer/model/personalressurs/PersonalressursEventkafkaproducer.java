package no.fintlabs.consumer.model.personalressurs;

import no.fintlabs.core.consumer.shared.resource.kafka.EventKafkaProducer;
import no.fintlabs.kafka.event.EventProducerFactory;
import no.fintlabs.kafka.event.topic.EventTopicService;
import org.springframework.stereotype.Service;

@Service
public class PersonalressursEventKafkaProducer extends EventKafkaProducer {
    public PersonalressursEventKafkaProducer(EventProducerFactory eventProducerFactory, PersonalressursConfig personalressursConfig, EventTopicService eventTopicService) {
        super(eventProducerFactory, personalressursConfig, eventTopicService);
    }
}
