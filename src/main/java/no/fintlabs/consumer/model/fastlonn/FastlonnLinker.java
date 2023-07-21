package no.fintlabs.consumer.model.fastlonn;

import no.fint.model.resource.administrasjon.personal.FastlonnResource;
import no.fint.model.resource.administrasjon.personal.FastlonnResources;
import no.fint.relations.FintLinker;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Objects.isNull;

@Component
public class FastlonnLinker extends FintLinker<FastlonnResource> {

    public FastlonnLinker() {
        super(FastlonnResource.class);
    }

    public void mapLinks(FastlonnResource resource) {
        super.mapLinks(resource);
    }

    @Override
    public FastlonnResources toResources(Collection<FastlonnResource> collection) {
        return toResources(collection.stream(), 0, 0, collection.size());
    }

    @Override
    public FastlonnResources toResources(Stream<FastlonnResource> stream, int offset, int size, int totalItems) {
        FastlonnResources resources = new FastlonnResources();
        stream.map(this::toResource).forEach(resources::addResource);
        addPagination(resources, offset, size, totalItems);
        return resources;
    }

    @Override
    public String getSelfHref(FastlonnResource resource) {
        return getAllSelfHrefs(resource).findFirst().orElse(null);
    }

    @Override
    public Stream<String> getAllSelfHrefs(FastlonnResource resource) {
        Stream.Builder<String> builder = Stream.builder();
        if (!isNull(resource.getSystemId()) && !StringUtils.isEmpty(resource.getSystemId().getIdentifikatorverdi())) {
            builder.add(createHrefWithId(resource.getSystemId().getIdentifikatorverdi(), "systemid"));
        }

        return builder.build();
    }

    int[] hashCodes(FastlonnResource resource) {
        IntStream.Builder builder = IntStream.builder();
        if (!isNull(resource.getSystemId()) && !StringUtils.isEmpty(resource.getSystemId().getIdentifikatorverdi())) {
            builder.add(resource.getSystemId().getIdentifikatorverdi().hashCode());
        }

        return builder.build().toArray();
    }
}