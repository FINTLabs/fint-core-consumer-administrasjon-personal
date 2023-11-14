package no.fintlabs.consumer.model.fasttillegg;

import no.fint.model.resource.administrasjon.personal.FasttilleggResource;
import no.fintlabs.core.consumer.shared.config.ConsumerProps;
import no.fintlabs.core.consumer.shared.resource.ConsumerConfig;
import org.springframework.stereotype.Component;

@Component
public class FasttilleggConfig extends ConsumerConfig<FasttilleggResource> {

    public FasttilleggConfig(ConsumerProps consumerProps) {
        super(consumerProps);
    }

    @Override
    protected String resourceName() {
        return "fasttillegg";
    }
}
