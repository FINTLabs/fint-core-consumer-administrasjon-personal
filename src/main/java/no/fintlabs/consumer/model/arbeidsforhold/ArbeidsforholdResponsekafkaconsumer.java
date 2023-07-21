package no.fintlabs.consumer.model.arbeidsforhold;

import no.fint.model.resource.administrasjon.personal.ArbeidsforholdResource;
import no.fintlabs.core.consumer.shared.resource.event.EventResponseKafkaConsumer;
import no.fintlabs.kafka.event.EventConsumerFactoryService;
import org.springframework.stereotype.Service;

@Service
public class ArbeidsforholdResponseKafkaConsumer extends EventResponseKafkaConsumer<ArbeidsforholdResource> {

    public ArbeidsforholdResponseKafkaConsumer(EventConsumerFactoryService eventConsumerFactoryService, ArbeidsforholdConfig arbeidsforholdConfig, ArbeidsforholdLinker arbeidsforholdLinker) {
        super(eventConsumerFactoryService, arbeidsforholdConfig, arbeidsforholdLinker);
    }

}
