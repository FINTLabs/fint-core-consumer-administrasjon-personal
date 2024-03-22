package no.fintlabs.consumer.config;

import com.google.common.collect.ImmutableMap;
import no.fint.model.administrasjon.personal.*;
import no.fint.model.felles.Person;

import java.util.Map;

public class LinkMapper {

    public static Map<String, String> linkMapper() {
        return ImmutableMap.<String, String>builder()
                .put(Arbeidsforhold.class.getName(), "/administrasjon/personal/arbeidsforhold")
                .put(Personalressurs.class.getName(), "/administrasjon/personal/personalressurs")
                .put(Variabellonn.class.getName(), "/administrasjon/personal/variabellonn")
                .put(Fravar.class.getName(), "/administrasjon/personal/fravar")
                .put(Fasttillegg.class.getName(), "/administrasjon/personal/fasttillegg")
                .put(Fastlonn.class.getName(), "/administrasjon/personal/fastlonn")
                .put(Person.class.getName(), "/administrasjon/personal/person")
                .build();
    }

}