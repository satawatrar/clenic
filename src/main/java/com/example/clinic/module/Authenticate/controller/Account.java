package com.example.clinic.module.Authenticate.controller;


//import com.example.clinic.module.Authenticate.model.SignOn;

import com.example.clinic.module.Authenticate.model.SignInRequest;
import com.example.clinic.module.Authenticate.model.SignInResponse;
import com.example.clinic.module.Authenticate.model.SignUpRequest;
import com.example.clinic.module.Authenticate.model.SignUpResponse;
import com.example.clinic.module.Authenticate.service.AuthenService;
import com.example.clinic.module.Authenticate.service.SignupService;
import com.example.clinic.module.Patiention.service.PatientionService;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequiredArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Account {

    @Autowired
    private SignupService signupService;


    @Autowired
    private PatientionService patientionService;

    @Autowired
    private AuthenService authenService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<SignInResponse> getAgent(@RequestBody SignInRequest request) {
        SignInResponse response = new SignInResponse();
        try {
            response = authenService.authenticate(request);
            response.success();
        }catch (Exception e){
            System.out.println("ERROR");
            response.fail("9000","login Fail");
        }
        return ResponseEntity.ok().body(response);
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<SignUpResponse> signUp(@RequestBody SignUpRequest request) {
        SignUpResponse response = new SignUpResponse();
        try {
            response = signupService.signUp(request);
            return ResponseEntity.ok().body(response);
        }catch (Exception e){
            response.fail("9000",e.getMessage());
            return ResponseEntity.ok().body(response);
        }
    }




}
