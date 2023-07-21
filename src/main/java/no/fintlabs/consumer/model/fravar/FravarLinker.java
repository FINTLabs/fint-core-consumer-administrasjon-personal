package no.fintlabs.consumer.model.fravar;

import no.fint.model.resource.administrasjon.personal.FravarResource;
import no.fint.model.resource.administrasjon.personal.FravarResources;
import no.fint.relations.FintLinker;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Objects.isNull;

@Component
public class FravarLinker extends FintLinker<FravarResource> {

    public FravarLinker() {
        super(FravarResource.class);
    }

    public void mapLinks(Fravar_REOSURCE resource) {
        super.mapLinks(resource);
    }

    @Override
    public FravarResources toResources(Collection<FravarResource> collection) {
        return toResources(collection.stream(), 0, 0, collection.size());
    }

    @Override
    public FravarResources toResources(Stream<FravarResource> stream, int offset, int size, int totalItems) {
        FravarResources resources = new FravarResources();
        stream.map(this::toResource).forEach(resources::addResource);
        addPagination(resources, offset, size, totalItems);
        return resources;
    }

    @Override
    public String getSelfHref(FravarResource resource) {
        return getAllSelfHrefs(resource).findFirst().orElse(null);
    }

    @Override
    public Stream<String> getAllSelfHrefs(FravarResource resource) {
        Stream.Builder<String> builder = Stream.builder();
        if (!isNull(resource.getSystemId()) && !StringUtils.isEmpty(resource.getSystemId().getIdentifikatorverdi())) {
            builder.add(createHrefWithId(resource.getSystemId().getIdentifikatorverdi(), "systemid"));
        }

        return builder.build();
    }

    int[] hashCodes(FravarResource resource) {
        IntStream.Builder builder = IntStream.builder();
        if (!isNull(resource.getSystemId()) && !StringUtils.isEmpty(resource.getSystemId().getIdentifikatorverdi())) {
            builder.add(resource.getSystemId().getIdentifikatorverdi().hashCode());
        }

        return builder.build().toArray();
    }
}