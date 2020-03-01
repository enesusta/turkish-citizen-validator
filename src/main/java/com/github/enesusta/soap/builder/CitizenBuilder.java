package com.github.enesusta.soap.builder;


import com.github.enesusta.soap.domain.Citizen;

import java.util.Locale;

public class CitizenBuilder {

    private long citizenId;
    private String citizenName;
    private String citizenSurname;
    private int citizenBirthYear;
    private static CitizenBuilder instance;
    private Locale locale = new Locale("tr", "TR");

    private CitizenBuilder() {

    }

    public static CitizenBuilder getInstance() {
        if (instance == null)
            instance = new CitizenBuilder();
        return instance;
    }

    public final CitizenBuilder setId(final long citizenId) {
        this.citizenId = citizenId;
        return this;
    }

    public final CitizenBuilder setName(final String citizenName) {
        this.citizenName = citizenName.toUpperCase(locale);
        return this;
    }

    public final CitizenBuilder setSurname(final String citizenSurname) {
        this.citizenSurname = citizenSurname.toUpperCase(locale);
        return this;
    }

    public final CitizenBuilder setBirthYear(final int citizenBirthYear) {
        this.citizenBirthYear = citizenBirthYear;
        return this;
    }

    public Citizen build() {
        return new Citizen(citizenId, citizenName, citizenSurname, citizenBirthYear);
    }
}
