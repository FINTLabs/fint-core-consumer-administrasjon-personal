package no.fintlabs.consumer.model.arbeidsforhold;

import lombok.extern.slf4j.Slf4j;
import no.fint.antlr.FintFilterService;
import no.fint.model.resource.administrasjon.personal.ArbeidsforholdResource;
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
@RequestMapping(name = "Arbeidsforhold", value = RestEndpoints.ARBEIDSFORHOLD, produces = {FintRelationsMediaType.APPLICATION_HAL_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
public class ArbeidsforholdController extends WriteableConsumerRestController<ArbeidsforholdResource> {

    public ArbeidsforholdController(
            CacheService<ArbeidsforholdResource> cacheService,
            ArbeidsforholdLinker fintLinker,
            ArbeidsforholdConfig arbeidsforholdConfig,
            ArbeidsforholdEventKafkaProducer arbeidsforholdEventKafkaProducer,
            ArbeidsforholdResponseKafkaConsumer arbeidsforholdResponseKafkaConsumer,
            FintFilterService odataFilterService,
            ArbeidsforholdRequestKafkaConsumer arbeidsforholdRequestKafkaConsumer) {
        super(cacheService, fintLinker, arbeidsforholdConfig, arbeidsforholdEventKafkaProducer, arbeidsforholdResponseKafkaConsumer, odataFilterService, arbeidsforholdRequestKafkaConsumer);
    }
}
