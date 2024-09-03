package no.fintlabs.consumer.model.fravar;

import no.fint.model.resource.administrasjon.personal.FravarResource;
import no.fintlabs.core.consumer.shared.resource.event.EventRequestKafkaConsumer;
import no.fintlabs.kafka.event.EventConsumerFactoryService;
import no.fintlabs.kafka.event.topic.EventTopicService;
import org.springframework.stereotype.Service;

@Service
public class FravarRequestKafkaConsumer extends EventRequestKafkaConsumer<FravarResource> {
    public FravarRequestKafkaConsumer(EventConsumerFactoryService eventConsumerFactoryService, FravarConfig fravarConfig, EventTopicService eventTopicService) {
        super(eventConsumerFactoryService, fravarConfig, eventTopicService);
    }
}
