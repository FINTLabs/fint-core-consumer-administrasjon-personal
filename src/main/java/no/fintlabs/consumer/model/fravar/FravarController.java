package no.fintlabs.consumer.model.fravar;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import no.fint.antlr.FintFilterService;
import no.fint.model.resource.administrasjon.personal.FravarResource;
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
@RequestMapping(name = "Fravar", value = RestEndpoints.FRAVAR, produces = {FintRelationsMediaType.APPLICATION_HAL_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
public class FravarController extends WriteableConsumerRestController<FravarResource> {

    public FravarController(
            CacheService<FravarResource> cacheService,
            FravarLinker fintLinker,
            FravarConfig fravarConfig,
            FravarEventKafkaProducer fravarEventKafkaProducer,
            FravarResponseKafkaConsumer fravarResponseKafkaConsumer,
            FintFilterService odataFilterService,
            FravarRequestKafkaConsumer fravarRequestKafkaConsumer) {
        super(cacheService, fintLinker, fravarConfig, fravarEventKafkaProducer, fravarResponseKafkaConsumer, odataFilterService, fravarRequestKafkaConsumer);
    }

    @PostConstruct
    private void registerIdentificators(){
        super.registerIdenficatorHandler("kildesystemId", FravarResource::getKildesystemId);
        super.registerIdenficatorHandler("systemid", FravarResource::getSystemId);
    }
}
