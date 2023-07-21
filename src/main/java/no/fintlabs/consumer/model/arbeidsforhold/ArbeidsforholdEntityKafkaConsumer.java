package no.fintlabs.consumer.model.arbeidsforhold;

import no.fint.model.resource.administrasjon.personal.ArbeidsforholdResource;
import no.fintlabs.core.consumer.shared.resource.kafka.EntityKafkaConsumer;
import no.fintlabs.kafka.common.ListenerBeanRegistrationService;
import no.fintlabs.kafka.entity.EntityConsumerFactoryService;
import no.fintlabs.kafka.entity.topic.EntityTopicService;
import org.springframework.stereotype.Service;

@Service
public class ArbeidsforholdEntityKafkaConsumer extends EntityKafkaConsumer<ArbeidsforholdResource> {

    public ArbeidsforholdEntityKafkaConsumer(
            EntityConsumerFactoryService entityConsumerFactoryService,
            ListenerBeanRegistrationService listenerBeanRegistrationService,
            EntityTopicService entityTopicService,
            ArbeidsforholdConfig arbeidsforholdConfig) {
        super(entityConsumerFactoryService, listenerBeanRegistrationService, entityTopicService, arbeidsforholdConfig);
    }
}
