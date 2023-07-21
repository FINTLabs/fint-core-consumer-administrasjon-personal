package no.fintlabs.consumer.model.personalressurs;

import no.fint.model.resource.administrasjon.personal.PersonalressursResource;
import no.fintlabs.core.consumer.shared.ConsumerProps;
import no.fintlabs.core.consumer.shared.resource.ConsumerConfig;
import org.springframework.stereotype.Component;

@Component
public class PersonalressursConfig extends ConsumerConfig<PersonalressursResource> {

    public PersonalressursConfig(ConsumerProps consumerProps) {
        super(consumerProps);
    }

    @Override
    protected String resourceName() {
        return "personalressurs";
    }
}
