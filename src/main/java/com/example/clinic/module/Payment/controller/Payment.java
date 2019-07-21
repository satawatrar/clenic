package com.example.clinic.module.Payment.controller;

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
public class Payment {


    @PostMapping(value = "/payment")
    public SignUpResponse getAgent(@RequestBody SignUpRequest request) {

        SignUpResponse response = new SignUpResponse();
        return response;
    }

    @PostMapping(value = "/print-reciept")
    public SignUpResponse printReciept(@RequestBody SignUpRequest request) {
        SignUpResponse response = new SignUpResponse();
        return response;
    }

    @GetMapping(value = "/get-expense")
    public SignUpResponse getExpense(@RequestBody SignUpRequest request) {
        SignUpResponse response = new SignUpResponse();
        return response;
    }

    @RequestMapping(value = "/add-expense", method = RequestMethod.POST)
    public SignUpResponse addExpense(@RequestBody SignUpRequest request) {
        SignUpResponse response = new SignUpResponse();
        return response;
    }



}
