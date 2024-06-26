package no.fintlabs.consumer.model.fasttillegg;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import no.fint.antlr.FintFilterService;
import no.fint.model.resource.administrasjon.personal.FasttilleggResource;
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
@RequestMapping(name = "Fasttillegg", value = RestEndpoints.FASTTILLEGG, produces = {FintRelationsMediaType.APPLICATION_HAL_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
public class FasttilleggController extends WriteableConsumerRestController<FasttilleggResource> {

    public FasttilleggController(
            CacheService<FasttilleggResource> cacheService,
            FasttilleggLinker fintLinker,
            FasttilleggConfig fasttilleggConfig,
            FasttilleggEventKafkaProducer fasttilleggEventKafkaProducer,
            FasttilleggResponseKafkaConsumer fasttilleggResponseKafkaConsumer,
            FintFilterService odataFilterService,
            FasttilleggRequestKafkaConsumer fasttilleggRequestKafkaConsumer) {
        super(cacheService, fintLinker, fasttilleggConfig, fasttilleggEventKafkaProducer, fasttilleggResponseKafkaConsumer, odataFilterService, fasttilleggRequestKafkaConsumer);
    }

    @PostConstruct
    private void registerIdentificators(){
        super.registerIdenficatorHandler("kildeSystemId", FasttilleggResource::getKildesystemId);
        super.registerIdenficatorHandler("systemid", FasttilleggResource::getSystemId);
    }
}
