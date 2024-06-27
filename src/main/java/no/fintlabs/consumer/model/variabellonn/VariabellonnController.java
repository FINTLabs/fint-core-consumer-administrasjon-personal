package no.fintlabs.consumer.model.variabellonn;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import no.fint.antlr.FintFilterService;
import no.fint.model.resource.administrasjon.personal.PersonalressursResource;
import no.fint.model.resource.administrasjon.personal.VariabellonnResource;
import no.fint.relations.FintRelationsMediaType;
import no.fintlabs.consumer.config.RestEndpoints;
import no.fintlabs.core.consumer.shared.resource.CacheService;
import no.fintlabs.core.consumer.shared.resource.WriteableConsumerRestController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping(name = "Variabellonn", value = RestEndpoints.VARIABELLONN, produces = {FintRelationsMediaType.APPLICATION_HAL_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
public class VariabellonnController extends WriteableConsumerRestController<VariabellonnResource> {

    public VariabellonnController(
            CacheService<VariabellonnResource> cacheService,
            VariabellonnLinker fintLinker,
            VariabellonnConfig variabellonnConfig,
            VariabellonnEventKafkaProducer variabellonnEventKafkaProducer,
            VariabellonnResponseKafkaConsumer variabellonnResponseKafkaConsumer,
            FintFilterService odataFilterService,
            VariabellonnRequestKafkaConsumer variabellonnRequestKafkaConsumer) {
        super(cacheService, fintLinker, variabellonnConfig, variabellonnEventKafkaProducer, variabellonnResponseKafkaConsumer, odataFilterService, variabellonnRequestKafkaConsumer);
    }

    @PostConstruct
    private void registerIdentificators() {
        super.registerIdenficatorHandler("kildeSystemid", VariabellonnResource::getKildesystemId);
        super.registerIdenficatorHandler("systemid", VariabellonnResource::getSystemId);
    }
}
