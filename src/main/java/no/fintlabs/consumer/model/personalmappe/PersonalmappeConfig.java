package no.fintlabs.consumer.model.personalmappe;

import no.fint.model.resource.administrasjon.personal.PersonalmappeResource;
import no.fintlabs.core.consumer.shared.ConsumerProps;
import no.fintlabs.core.consumer.shared.resource.ConsumerConfig;
import org.springframework.stereotype.Component;

@Component
public class PersonalmappeConfig extends ConsumerConfig<PersonalmappeResource> {

    public PersonalmappeConfig(ConsumerProps consumerProps) {
        super(consumerProps);
    }

    @Override
    protected String resourceName() {
        return "personalmappe";
    }
}
