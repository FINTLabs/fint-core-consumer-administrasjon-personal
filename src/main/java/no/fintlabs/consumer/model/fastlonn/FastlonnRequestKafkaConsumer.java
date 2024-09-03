package no.fintlabs.consumer.model.fastlonn;

import no.fint.model.resource.administrasjon.personal.FastlonnResource;
import no.fintlabs.core.consumer.shared.resource.event.EventRequestKafkaConsumer;
import no.fintlabs.kafka.event.EventConsumerFactoryService;
import no.fintlabs.kafka.event.topic.EventTopicService;
import org.springframework.stereotype.Service;

@Service
public class FastlonnRequestKafkaConsumer extends EventRequestKafkaConsumer<FastlonnResource> {
    public FastlonnRequestKafkaConsumer(EventConsumerFactoryService eventConsumerFactoryService, FastlonnConfig fastlonnConfig, EventTopicService eventTopicService) {
        super(eventConsumerFactoryService, fastlonnConfig, eventTopicService);
    }
}
