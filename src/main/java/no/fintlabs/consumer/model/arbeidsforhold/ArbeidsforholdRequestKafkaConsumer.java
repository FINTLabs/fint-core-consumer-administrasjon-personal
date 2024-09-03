package no.fintlabs.consumer.model.arbeidsforhold;

import no.fint.model.resource.administrasjon.personal.ArbeidsforholdResource;
import no.fintlabs.core.consumer.shared.resource.event.EventRequestKafkaConsumer;
import no.fintlabs.kafka.event.EventConsumerFactoryService;
import no.fintlabs.kafka.event.topic.EventTopicService;
import org.springframework.stereotype.Service;

@Service
public class ArbeidsforholdRequestKafkaConsumer extends EventRequestKafkaConsumer<ArbeidsforholdResource> {
    public ArbeidsforholdRequestKafkaConsumer(EventConsumerFactoryService eventConsumerFactoryService, ArbeidsforholdConfig arbeidsforholdConfig, EventTopicService eventTopicService) {
        super(eventConsumerFactoryService, arbeidsforholdConfig, eventTopicService);
    }
}
