package no.fintlabs.consumer.model.personalressurs;

import no.fint.model.resource.administrasjon.personal.PersonalressursResource;
import no.fintlabs.core.consumer.shared.resource.event.EventResponseKafkaConsumer;
import no.fintlabs.kafka.event.EventConsumerFactoryService;
import no.fintlabs.kafka.event.topic.EventTopicService;
import org.springframework.stereotype.Service;

@Service
public class PersonalressursResponseKafkaConsumer extends EventResponseKafkaConsumer<PersonalressursResource> {

    public PersonalressursResponseKafkaConsumer(EventConsumerFactoryService eventConsumerFactoryService, PersonalressursConfig personalressursConfig, PersonalressursLinker personalressursLinker, EventTopicService eventTopicService) {
        super(eventConsumerFactoryService, personalressursConfig, personalressursLinker, eventTopicService);
    }

}
