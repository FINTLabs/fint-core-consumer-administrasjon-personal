package no.fintlabs.consumer.model.variabellonn;

import no.fint.model.resource.administrasjon.personal.VariabellonnResource;
import no.fintlabs.core.consumer.shared.config.ConsumerProps;
import no.fintlabs.core.consumer.shared.resource.ConsumerConfig;
import org.springframework.stereotype.Component;

@Component
public class VariabellonnConfig extends ConsumerConfig<VariabellonnResource> {

    public VariabellonnConfig(ConsumerProps consumerProps) {
        super(consumerProps);
    }

    @Override
    protected String resourceName() {
        return "variabellonn";
    }
}
