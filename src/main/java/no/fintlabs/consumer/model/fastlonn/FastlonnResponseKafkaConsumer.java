package no.fintlabs.consumer.model.fastlonn;

import no.fint.model.resource.administrasjon.personal.FastlonnResource;
import no.fintlabs.core.consumer.shared.resource.event.EventResponseKafkaConsumer;
import no.fintlabs.kafka.event.EventConsumerFactoryService;
import no.fintlabs.kafka.event.topic.EventTopicService;
import org.springframework.stereotype.Service;

@Service
public class FastlonnResponseKafkaConsumer extends EventResponseKafkaConsumer<FastlonnResource> {

    public FastlonnResponseKafkaConsumer(EventConsumerFactoryService eventConsumerFactoryService, FastlonnConfig fastlonnConfig, FastlonnLinker fastlonnLinker, EventTopicService eventTopicService) {
        super(eventConsumerFactoryService, fastlonnConfig, fastlonnLinker, eventTopicService);
    }

}
