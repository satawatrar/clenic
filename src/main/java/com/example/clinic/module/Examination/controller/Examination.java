package com.example.clinic.module.Examination.controller;


//import com.example.clinic.module.Authenticate.model.SignOn;

import com.example.clinic.module.Authenticate.model.SignUpRequest;
import com.example.clinic.module.Authenticate.model.SignUpResponse;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequiredArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Examination {


    // move from class "GetAgentController"
    @GetMapping(value = "/examination-result")
    public SignUpResponse getAgent(@RequestBody SignUpRequest request) {

        SignUpResponse response = new SignUpResponse();
        return response;
    }



}
