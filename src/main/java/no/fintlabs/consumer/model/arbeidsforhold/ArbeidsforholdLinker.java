package no.fintlabs.consumer.model.arbeidsforhold;

import no.fint.model.resource.administrasjon.personal.ArbeidsforholdResource;
import no.fint.model.resource.administrasjon.personal.ArbeidsforholdResources;
import no.fint.relations.FintLinker;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Objects.isNull;

@Component
public class ArbeidsforholdLinker extends FintLinker<ArbeidsforholdResource> {

    public ArbeidsforholdLinker() {
        super(ArbeidsforholdResource.class);
    }

    public void mapLinks(Arbeidsforhold_REOSURCE resource) {
        super.mapLinks(resource);
    }

    @Override
    public ArbeidsforholdResources toResources(Collection<ArbeidsforholdResource> collection) {
        return toResources(collection.stream(), 0, 0, collection.size());
    }

    @Override
    public ArbeidsforholdResources toResources(Stream<ArbeidsforholdResource> stream, int offset, int size, int totalItems) {
        ArbeidsforholdResources resources = new ArbeidsforholdResources();
        stream.map(this::toResource).forEach(resources::addResource);
        addPagination(resources, offset, size, totalItems);
        return resources;
    }

    @Override
    public String getSelfHref(ArbeidsforholdResource resource) {
        return getAllSelfHrefs(resource).findFirst().orElse(null);
    }

    @Override
    public Stream<String> getAllSelfHrefs(ArbeidsforholdResource resource) {
        Stream.Builder<String> builder = Stream.builder();
        if (!isNull(resource.getSystemId()) && !StringUtils.isEmpty(resource.getSystemId().getIdentifikatorverdi())) {
            builder.add(createHrefWithId(resource.getSystemId().getIdentifikatorverdi(), "systemid"));
        }

        return builder.build();
    }

    int[] hashCodes(ArbeidsforholdResource resource) {
        IntStream.Builder builder = IntStream.builder();
        if (!isNull(resource.getSystemId()) && !StringUtils.isEmpty(resource.getSystemId().getIdentifikatorverdi())) {
            builder.add(resource.getSystemId().getIdentifikatorverdi().hashCode());
        }

        return builder.build().toArray();
    }
}