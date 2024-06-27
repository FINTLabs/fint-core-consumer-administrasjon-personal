package no.fintlabs.consumer.model.fastlonn;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import no.fint.antlr.FintFilterService;
import no.fint.model.resource.administrasjon.personal.FastlonnResource;
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
@RequestMapping(name = "Fastlonn", value = RestEndpoints.FASTLONN, produces = {FintRelationsMediaType.APPLICATION_HAL_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
public class FastlonnController extends WriteableConsumerRestController<FastlonnResource> {

    public FastlonnController(
            CacheService<FastlonnResource> cacheService,
            FastlonnLinker fintLinker,
            FastlonnConfig fastlonnConfig,
            FastlonnEventKafkaProducer fastlonnEventKafkaProducer,
            FastlonnResponseKafkaConsumer fastlonnResponseKafkaConsumer,
            FintFilterService odataFilterService,
            FastlonnRequestKafkaConsumer fastlonnRequestKafkaConsumer) {
        super(cacheService, fintLinker, fastlonnConfig, fastlonnEventKafkaProducer, fastlonnResponseKafkaConsumer, odataFilterService, fastlonnRequestKafkaConsumer);
    }

    @PostConstruct
    private void registerIdentificators(){
        super.registerIdenficatorHandler("kildeSystemId", FastlonnResource::getSystemId);
        super.registerIdenficatorHandler("systemid", FastlonnResource::getSystemId);
    }
}
