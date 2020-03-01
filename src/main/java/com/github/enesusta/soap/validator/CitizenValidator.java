package com.github.enesusta.soap.validator;

import com.github.enesusta.soap.domain.Citizen;

import javax.xml.soap.SOAPMessage;

public interface CitizenValidator {
    boolean validate(Citizen citizen);

    boolean request(SOAPMessage soapMessage);
}
