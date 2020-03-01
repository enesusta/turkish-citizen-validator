package com.github.enesusta.soap.validator;

import com.github.enesusta.soap.domain.Citizen;
import com.github.enesusta.soap.message.DefaultMessage;
import com.github.enesusta.soap.message.Message;

import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

public class DefaultCitizenValidator implements CitizenValidator {

    private Message message;
    private static final String SERVICE_URL = "https://tckimlik.nvi.gov.tr/Service/KPSPublic.asmx?WSDL";

    public DefaultCitizenValidator() {
        message = new DefaultMessage();
    }

    @Override
    public final boolean validate(final Citizen citizen) {
        boolean result = false;
        try {
            result = request(message.getMessage(citizen));
        } catch (SOAPException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public final boolean request(final SOAPMessage soapMessage) {

        Boolean result = null;
        try {

            final SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            final SOAPConnection soapConnection = soapConnectionFactory.createConnection();
            final SOAPMessage response = soapConnection.call(soapMessage, SERVICE_URL);
            final String responseBody = response.getSOAPBody().getTextContent();
            result = Boolean.valueOf(responseBody);
            soapConnection.close();

        } catch (SOAPException e) {
            e.printStackTrace();
        }

        return result;
    }
}
