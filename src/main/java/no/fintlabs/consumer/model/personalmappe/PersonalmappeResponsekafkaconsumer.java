package no.fintlabs.consumer.model.personalmappe;

import no.fint.model.resource.administrasjon.personal.PersonalmappeResource;
import no.fintlabs.core.consumer.shared.resource.event.EventResponseKafkaConsumer;
import no.fintlabs.kafka.event.EventConsumerFactoryService;
import org.springframework.stereotype.Service;

@Service
public class PersonalmappeResponseKafkaConsumer extends EventResponseKafkaConsumer<PersonalmappeResource> {

    public PersonalmappeResponseKafkaConsumer(EventConsumerFactoryService eventConsumerFactoryService, PersonalmappeConfig personalmappeConfig, PersonalmappeLinker personalmappeLinker) {
        super(eventConsumerFactoryService, personalmappeConfig, personalmappeLinker);
    }

}
