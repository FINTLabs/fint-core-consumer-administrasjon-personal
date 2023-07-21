package no.fintlabs.consumer.model.fasttillegg;

import no.fint.model.resource.administrasjon.personal.FasttilleggResource;
import no.fint.model.resource.administrasjon.personal.FasttilleggResources;
import no.fint.relations.FintLinker;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Objects.isNull;

@Component
public class FasttilleggLinker extends FintLinker<FasttilleggResource> {

    public FasttilleggLinker() {
        super(FasttilleggResource.class);
    }

    public void mapLinks(FasttilleggResource resource) {
        super.mapLinks(resource);
    }

    @Override
    public FasttilleggResources toResources(Collection<FasttilleggResource> collection) {
        return toResources(collection.stream(), 0, 0, collection.size());
    }

    @Override
    public FasttilleggResources toResources(Stream<FasttilleggResource> stream, int offset, int size, int totalItems) {
        FasttilleggResources resources = new FasttilleggResources();
        stream.map(this::toResource).forEach(resources::addResource);
        addPagination(resources, offset, size, totalItems);
        return resources;
    }

    @Override
    public String getSelfHref(FasttilleggResource resource) {
        return getAllSelfHrefs(resource).findFirst().orElse(null);
    }

    @Override
    public Stream<String> getAllSelfHrefs(FasttilleggResource resource) {
        Stream.Builder<String> builder = Stream.builder();
        if (!isNull(resource.getSystemId()) && !StringUtils.isEmpty(resource.getSystemId().getIdentifikatorverdi())) {
            builder.add(createHrefWithId(resource.getSystemId().getIdentifikatorverdi(), "systemid"));
        }

        return builder.build();
    }

    int[] hashCodes(FasttilleggResource resource) {
        IntStream.Builder builder = IntStream.builder();
        if (!isNull(resource.getSystemId()) && !StringUtils.isEmpty(resource.getSystemId().getIdentifikatorverdi())) {
            builder.add(resource.getSystemId().getIdentifikatorverdi().hashCode());
        }

        return builder.build().toArray();
    }
}