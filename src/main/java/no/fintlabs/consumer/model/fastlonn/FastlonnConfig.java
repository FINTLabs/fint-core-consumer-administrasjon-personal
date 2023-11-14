package no.fintlabs.consumer.model.fastlonn;

import no.fint.model.resource.administrasjon.personal.FastlonnResource;
import no.fintlabs.core.consumer.shared.config.ConsumerProps;
import no.fintlabs.core.consumer.shared.resource.ConsumerConfig;
import org.springframework.stereotype.Component;

@Component
public class FastlonnConfig extends ConsumerConfig<FastlonnResource> {

    public FastlonnConfig(ConsumerProps consumerProps) {
        super(consumerProps);
    }

    @Override
    protected String resourceName() {
        return "fastlonn";
    }
}
