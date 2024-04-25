package demo.soap.services;

import demo.soap.webservice_soap.AgeResponse;
import demo.soap.webservice_soap.BirthDateResponse;
import demo.soap.webservice_soap.BirthdayNameRequest;
import demo.soap.webservice_soap.BirthdayRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Service
public class BirthdayServiceImpl implements BirthdayService {
    Jaxb2Marshaller jaxb2Marshaller;

    @Autowired
    public BirthdayServiceImpl(Jaxb2Marshaller jaxb2Marshaller) {
        this.jaxb2Marshaller = jaxb2Marshaller;
    }

    @Override
    public AgeResponse getAge(BirthdayRequest getBirthdayRequest) {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller);
        AgeResponse getAgeResponse = (AgeResponse) webServiceTemplate
                .marshalSendAndReceive("http://localhost:8080/ws", getBirthdayRequest);
        return getAgeResponse;
    }

    @Override
    public BirthDateResponse getBirthDate(BirthdayNameRequest birthdayNameRequest) {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller);
        BirthDateResponse birthDateResponse = (BirthDateResponse) webServiceTemplate
                .marshalSendAndReceive("http://localhost:8080/ws", birthdayNameRequest);
        return birthDateResponse;
    }
}
