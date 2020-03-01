package com.github.enesusta.soap.domain;

public class Citizen {

    private long citizenId;
    private String citizenName;
    private String citizenSurname;
    private int citizenBirthYear;

    public Citizen(long citizenId,
                   String citizenName,
                   String citizenSurname,
                   int citizenBirthYear) {
        this.citizenId = citizenId;
        this.citizenName = citizenName;
        this.citizenSurname = citizenSurname;
        this.citizenBirthYear = citizenBirthYear;
    }

    public long getCitizenId() {
        return citizenId;
    }

    public String getCitizenName() {
        return citizenName;
    }

    public String getCitizenSurname() {
        return citizenSurname;
    }

    public int getCitizenBirthYear() {
        return citizenBirthYear;
    }
}
