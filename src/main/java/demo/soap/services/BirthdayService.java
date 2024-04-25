package demo.soap.services;

import demo.soap.webservice_soap.AgeResponse;
import demo.soap.webservice_soap.BirthDateResponse;
import demo.soap.webservice_soap.BirthdayNameRequest;
import demo.soap.webservice_soap.BirthdayRequest;

public interface BirthdayService {
    AgeResponse getAge(BirthdayRequest getBirthdayRequest);
    BirthDateResponse getBirthDate(BirthdayNameRequest birthdayNameRequest);
}
