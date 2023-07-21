package no.fintlabs.consumer.model.variabellonn;

import no.fint.model.resource.administrasjon.personal.VariabellonnResource;
import no.fint.model.resource.administrasjon.personal.VariabellonnResources;
import no.fint.relations.FintLinker;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Objects.isNull;

@Component
public class VariabellonnLinker extends FintLinker<VariabellonnResource> {

    public VariabellonnLinker() {
        super(VariabellonnResource.class);
    }

    public void mapLinks(VariabellonnResource resource) {
        super.mapLinks(resource);
    }

    @Override
    public VariabellonnResources toResources(Collection<VariabellonnResource> collection) {
        return toResources(collection.stream(), 0, 0, collection.size());
    }

    @Override
    public VariabellonnResources toResources(Stream<VariabellonnResource> stream, int offset, int size, int totalItems) {
        VariabellonnResources resources = new VariabellonnResources();
        stream.map(this::toResource).forEach(resources::addResource);
        addPagination(resources, offset, size, totalItems);
        return resources;
    }

    @Override
    public String getSelfHref(VariabellonnResource resource) {
        return getAllSelfHrefs(resource).findFirst().orElse(null);
    }

    @Override
    public Stream<String> getAllSelfHrefs(VariabellonnResource resource) {
        Stream.Builder<String> builder = Stream.builder();
        if (!isNull(resource.getSystemId()) && !StringUtils.isEmpty(resource.getSystemId().getIdentifikatorverdi())) {
            builder.add(createHrefWithId(resource.getSystemId().getIdentifikatorverdi(), "systemid"));
        }

        return builder.build();
    }

    int[] hashCodes(VariabellonnResource resource) {
        IntStream.Builder builder = IntStream.builder();
        if (!isNull(resource.getSystemId()) && !StringUtils.isEmpty(resource.getSystemId().getIdentifikatorverdi())) {
            builder.add(resource.getSystemId().getIdentifikatorverdi().hashCode());
        }

        return builder.build().toArray();
    }
}