package no.fintlabs.consumer.model.fasttillegg;

import no.fint.model.resource.administrasjon.personal.FasttilleggResource;
import no.fintlabs.core.consumer.shared.resource.event.EventResponseKafkaConsumer;
import no.fintlabs.kafka.event.EventConsumerFactoryService;
import org.springframework.stereotype.Service;

@Service
public class FasttilleggResponseKafkaConsumer extends EventResponseKafkaConsumer<FasttilleggResource> {

    public FasttilleggResponseKafkaConsumer(EventConsumerFactoryService eventConsumerFactoryService, FasttilleggConfig fasttilleggConfig, FasttilleggLinker fasttilleggLinker) {
        super(eventConsumerFactoryService, fasttilleggConfig, fasttilleggLinker);
    }

}
