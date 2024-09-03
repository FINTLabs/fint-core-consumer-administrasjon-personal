package no.fintlabs.consumer.model.fasttillegg;

import no.fint.model.resource.administrasjon.personal.FasttilleggResource;
import no.fintlabs.core.consumer.shared.resource.event.EventRequestKafkaConsumer;
import no.fintlabs.kafka.event.EventConsumerFactoryService;
import no.fintlabs.kafka.event.topic.EventTopicService;
import org.springframework.stereotype.Service;

@Service
public class FasttilleggRequestKafkaConsumer extends EventRequestKafkaConsumer<FasttilleggResource> {
    public FasttilleggRequestKafkaConsumer(EventConsumerFactoryService eventConsumerFactoryService, FasttilleggConfig fasttilleggConfig, EventTopicService eventTopicService) {
        super(eventConsumerFactoryService, fasttilleggConfig, eventTopicService);
    }
}
