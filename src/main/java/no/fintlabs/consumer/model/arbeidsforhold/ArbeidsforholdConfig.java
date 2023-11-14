package no.fintlabs.consumer.model.arbeidsforhold;

import no.fint.model.resource.administrasjon.personal.ArbeidsforholdResource;
import no.fintlabs.core.consumer.shared.config.ConsumerProps;
import no.fintlabs.core.consumer.shared.resource.ConsumerConfig;
import org.springframework.stereotype.Component;

@Component
public class ArbeidsforholdConfig extends ConsumerConfig<ArbeidsforholdResource> {

    public ArbeidsforholdConfig(ConsumerProps consumerProps) {
        super(consumerProps);
    }

    @Override
    protected String resourceName() {
        return "arbeidsforhold";
    }
}
