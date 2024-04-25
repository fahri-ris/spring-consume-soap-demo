package demo.soap.controllers;

import demo.soap.services.BirthdayService;
import demo.soap.webservice_soap.AgeResponse;
import demo.soap.webservice_soap.BirthdayRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/birthday")
public class BirthdayController {
    BirthdayService birthdayService;

    @Autowired
    public BirthdayController(BirthdayService birthdayService) {
        this.birthdayService = birthdayService;
    }

    @PostMapping()
    public ResponseEntity<AgeResponse> getAge(@RequestBody BirthdayRequest getBirthdayRequest) {
        return ResponseEntity.ok(birthdayService.getAge(getBirthdayRequest));
    }
}
