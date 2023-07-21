package no.fintlabs.consumer.model.fravar;

import no.fint.model.resource.administrasjon.personal.FravarResource;
import no.fintlabs.core.consumer.shared.resource.event.EventResponseKafkaConsumer;
import no.fintlabs.kafka.event.EventConsumerFactoryService;
import org.springframework.stereotype.Service;

@Service
public class FravarResponseKafkaConsumer extends EventResponseKafkaConsumer<FravarResource> {

    public FravarResponseKafkaConsumer(EventConsumerFactoryService eventConsumerFactoryService, FravarConfig fravarConfig, FravarLinker fravarLinker) {
        super(eventConsumerFactoryService, fravarConfig, fravarLinker);
    }

}
