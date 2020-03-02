package com.github.enesusta.soap.tutorial;

import com.github.enesusta.soap.builder.CitizenBuilder;
import com.github.enesusta.soap.domain.Citizen;
import com.github.enesusta.soap.validator.CitizenValidator;
import com.github.enesusta.soap.validator.DefaultCitizenValidator;

public class Tutorial {
    public static void main(String[] args) {

        Citizen citizen = CitizenBuilder
                .getInstance()
                .setId(24958658434L)
                .setName("Sabri")
                .setSurname("Usta")
                .setBirthYear(1972)
                .build();

        CitizenValidator citizenValidator = new DefaultCitizenValidator();
        boolean isValidId = citizenValidator.validate(citizen);
        System.out.println("isValidId = " + isValidId);

    }
}
