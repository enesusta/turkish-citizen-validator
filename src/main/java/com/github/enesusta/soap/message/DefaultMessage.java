package com.github.enesusta.soap.message;

import com.github.enesusta.soap.domain.Citizen;

import javax.xml.soap.*;

public final class DefaultMessage implements Message {

    private static final String NAME_SPACE = "targetNameSpace";

    @Override
    public final SOAPMessage getMessage(final Citizen citizen) throws SOAPException {

        final MessageFactory messageFactory = MessageFactory.newInstance();
        final SOAPMessage soapMessage = messageFactory.createMessage();
        final SOAPPart soapPart = soapMessage.getSOAPPart();
        final SOAPEnvelope envelope = prepareEnvelope(soapPart);
        final SOAPBody soapBody = envelope.getBody();

        final SOAPElement tcKnValidate = soapBody.addChildElement("TCKimlikNoDogrula", NAME_SPACE);
        final SOAPElement tckNo = tcKnValidate.addChildElement("TCKimlikNo", NAME_SPACE);
        final SOAPElement name = tcKnValidate.addChildElement("Ad", NAME_SPACE);
        final SOAPElement surname = tcKnValidate.addChildElement("Soyad", NAME_SPACE);
        final SOAPElement birthYear = tcKnValidate.addChildElement("DogumYili", NAME_SPACE);

        tckNo.addTextNode(String.valueOf(citizen.getCitizenId()));
        name.addTextNode(citizen.getCitizenName());
        surname.addTextNode(citizen.getCitizenSurname());
        birthYear.addTextNode(String.valueOf(citizen.getCitizenBirthYear()));

        soapMessage.saveChanges();
        return soapMessage;
    }

    private SOAPEnvelope prepareEnvelope(final SOAPPart soapPart) throws SOAPException {

        final SOAPEnvelope envelope = soapPart.getEnvelope();

        envelope.addNamespaceDeclaration("xsi", "http://www.w3.org/2001/XMLSchema-instance");
        envelope.addNamespaceDeclaration("xsd", "http://www.w3.org/2001/XMLSchema");
        envelope.addNamespaceDeclaration("soap12", "http://www.w3.org/2003/05/soap-envelope");
        envelope.addNamespaceDeclaration(NAME_SPACE, "http://tckimlik.nvi.gov.tr/WS");

        return envelope;
    }
}
