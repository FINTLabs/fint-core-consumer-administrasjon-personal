package no.fintlabs.consumer.model.personalmappe;

import lombok.extern.slf4j.Slf4j;
import no.fint.antlr.FintFilterService;
import no.fint.model.resource.administrasjon.personal.PersonalmappeResource;
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
@RequestMapping(name = "Personalmappe", value = RestEndpoints.PERSONALMAPPE, produces = {FintRelationsMediaType.APPLICATION_HAL_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
public class PersonalmappeController extends WriteableConsumerRestController<PersonalmappeResource> {

    public PersonalmappeController(
            CacheService<PersonalmappeResource> cacheService,
            PersonalmappeLinker fintLinker,
            PersonalmappeConfig personalmappeConfig,
            PersonalmappeEventKafkaProducer personalmappeEventKafkaProducer,
            PersonalmappeResponseKafkaConsumer personalmappeResponseKafkaConsumer,
            FintFilterService odataFilterService,
            PersonalmappeRequestKafkaConsumer personalmappeRequestKafkaConsumer) {
        super(cacheService, fintLinker, personalmappeConfig, personalmappeEventKafkaProducer, personalmappeResponseKafkaConsumer, odataFilterService, personalmappeRequestKafkaConsumer);
    }
}
