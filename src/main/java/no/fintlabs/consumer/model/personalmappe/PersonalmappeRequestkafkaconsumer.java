package no.fintlabs.consumer.model.personalmappe;

import no.fint.model.resource.administrasjon.personal.PersonalmappeResource;
import no.fintlabs.core.consumer.shared.resource.event.EventRequestKafkaConsumer;
import no.fintlabs.kafka.event.EventConsumerFactoryService;
import org.springframework.stereotype.Service;

@Service
public class PersonalmappeRequestKafkaConsumer extends EventRequestKafkaConsumer<PersonalmappeResource> {
    public PersonalmappeRequestKafkaConsumer(EventConsumerFactoryService eventConsumerFactoryService, PersonalmappeConfig personalmappeConfig) {
        super(eventConsumerFactoryService, personalmappeConfig);
    }
}
