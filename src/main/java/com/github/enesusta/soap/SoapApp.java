package com.github.enesusta.soap;

import com.github.enesusta.soap.builder.CitizenBuilder;
import com.github.enesusta.soap.domain.Citizen;

public class SoapApp {

    public static void main(String[] args) {

        Citizen citizen = CitizenBuilder
                .getInstance()
                .setId(24931659380L)
                .setName("Sabri")
                .setSurname("öztürk")
                .setBirthYear(1998)
                .build();

        System.out.println(citizen.getCitizenName());
        System.out.println(citizen.getCitizenSurname());

    }

}
