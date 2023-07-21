package no.fintlabs.consumer.model.personalmappe;

import no.fint.model.resource.administrasjon.personal.PersonalmappeResource;
import no.fint.model.resource.administrasjon.personal.PersonalmappeResources;
import no.fint.relations.FintLinker;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Objects.isNull;

@Component
public class PersonalmappeLinker extends FintLinker<PersonalmappeResource> {

    public PersonalmappeLinker() {
        super(PersonalmappeResource.class);
    }

    public void mapLinks(Personalmappe_REOSURCE resource) {
        super.mapLinks(resource);
    }

    @Override
    public PersonalmappeResources toResources(Collection<PersonalmappeResource> collection) {
        return toResources(collection.stream(), 0, 0, collection.size());
    }

    @Override
    public PersonalmappeResources toResources(Stream<PersonalmappeResource> stream, int offset, int size, int totalItems) {
        PersonalmappeResources resources = new PersonalmappeResources();
        stream.map(this::toResource).forEach(resources::addResource);
        addPagination(resources, offset, size, totalItems);
        return resources;
    }

    @Override
    public String getSelfHref(PersonalmappeResource resource) {
        return getAllSelfHrefs(resource).findFirst().orElse(null);
    }

    @Override
    public Stream<String> getAllSelfHrefs(PersonalmappeResource resource) {
        Stream.Builder<String> builder = Stream.builder();
        if (!isNull(resource.getSystemId()) && !StringUtils.isEmpty(resource.getSystemId().getIdentifikatorverdi())) {
            builder.add(createHrefWithId(resource.getSystemId().getIdentifikatorverdi(), "systemid"));
        }

        return builder.build();
    }

    int[] hashCodes(PersonalmappeResource resource) {
        IntStream.Builder builder = IntStream.builder();
        if (!isNull(resource.getSystemId()) && !StringUtils.isEmpty(resource.getSystemId().getIdentifikatorverdi())) {
            builder.add(resource.getSystemId().getIdentifikatorverdi().hashCode());
        }

        return builder.build().toArray();
    }
}