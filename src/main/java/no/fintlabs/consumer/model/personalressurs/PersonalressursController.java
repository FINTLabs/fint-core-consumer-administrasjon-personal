package no.fintlabs.consumer.model.personalressurs;

import lombok.extern.slf4j.Slf4j;
import no.fint.antlr.FintFilterService;
import no.fint.model.resource.administrasjon.personal.PersonalressursResource;
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
@RequestMapping(name = "Personalressurs", value = RestEndpoints.PERSONALRESSURS, produces = {FintRelationsMediaType.APPLICATION_HAL_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
public class PersonalressursController extends WriteableConsumerRestController<PersonalressursResource> {

    public PersonalressursController(
            CacheService<PersonalressursResource> cacheService,
            PersonalressursLinker fintLinker,
            PersonalressursConfig personalressursConfig,
            PersonalressursEventKafkaProducer personalressursEventKafkaProducer,
            PersonalressursResponseKafkaConsumer personalressursResponseKafkaConsumer,
            FintFilterService odataFilterService,
            PersonalressursRequestKafkaConsumer personalressursRequestKafkaConsumer) {
        super(cacheService, fintLinker, personalressursConfig, personalressursEventKafkaProducer, personalressursResponseKafkaConsumer, odataFilterService, personalressursRequestKafkaConsumer);
    }
}
