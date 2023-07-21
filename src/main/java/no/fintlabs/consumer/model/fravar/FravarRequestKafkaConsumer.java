package no.fintlabs.consumer.model.fravar;

import no.fint.model.resource.administrasjon.personal.FravarResource;
import no.fintlabs.core.consumer.shared.resource.event.EventRequestKafkaConsumer;
import no.fintlabs.kafka.event.EventConsumerFactoryService;
import org.springframework.stereotype.Service;

@Service
public class FravarRequestKafkaConsumer extends EventRequestKafkaConsumer<FravarResource> {
    public FravarRequestKafkaConsumer(EventConsumerFactoryService eventConsumerFactoryService, FravarConfig fravarConfig) {
        super(eventConsumerFactoryService, fravarConfig);
    }
}
