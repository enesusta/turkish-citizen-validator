package com.github.enesusta.soap.message;

import com.github.enesusta.soap.domain.Citizen;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

public interface Message {
    SOAPMessage getMessage(Citizen citizen) throws SOAPException;
}
