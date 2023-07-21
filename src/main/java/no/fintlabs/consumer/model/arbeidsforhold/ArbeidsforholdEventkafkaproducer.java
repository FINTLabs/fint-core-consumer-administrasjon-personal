package no.fintlabs.consumer.model.arbeidsforhold;

import no.fintlabs.core.consumer.shared.resource.kafka.EventKafkaProducer;
import no.fintlabs.kafka.event.EventProducerFactory;
import no.fintlabs.kafka.event.topic.EventTopicService;
import org.springframework.stereotype.Service;

@Service
public class ArbeidsforholdEventKafkaProducer extends EventKafkaProducer {
    public ArbeidsforholdEventKafkaProducer(EventProducerFactory eventProducerFactory, ArbeidsforholdConfig arbeidsforholdConfig, EventTopicService eventTopicService) {
        super(eventProducerFactory, arbeidsforholdConfig, eventTopicService);
    }
}
