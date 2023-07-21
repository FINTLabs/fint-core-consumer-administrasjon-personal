package no.fintlabs.consumer.model.personalressurs;

import no.fint.model.resource.administrasjon.personal.PersonalressursResource;
import no.fintlabs.core.consumer.shared.resource.event.EventRequestKafkaConsumer;
import no.fintlabs.kafka.event.EventConsumerFactoryService;
import org.springframework.stereotype.Service;

@Service
public class PersonalressursRequestKafkaConsumer extends EventRequestKafkaConsumer<PersonalressursResource> {
    public PersonalressursRequestKafkaConsumer(EventConsumerFactoryService eventConsumerFactoryService, PersonalressursConfig personalressursConfig) {
        super(eventConsumerFactoryService, personalressursConfig);
    }
}
