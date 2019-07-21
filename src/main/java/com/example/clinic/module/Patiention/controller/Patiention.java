package com.example.clinic.module.Patiention.controller;


//import com.example.clinic.module.Authenticate.model.SignOn;

import com.example.clinic.module.Authenticate.model.SignUpRequest;
import com.example.clinic.module.Authenticate.model.SignUpResponse;
import com.example.clinic.module.Patiention.model.PatientFillUpRequest;
import com.example.clinic.module.Patiention.model.PatientFillUpResponse;
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
public class Patiention {

    @Autowired
    private PatientionService patientionService;


    // move from class "GetAgentController"
    @PostMapping(value = "/appointment")
    public SignUpResponse appointment(@RequestBody SignUpRequest request) {
        SignUpResponse response = new SignUpResponse();
        return response;
    }

    @PostMapping(value = "/get-appointment-detail")
    public SignUpResponse getAppointment(@RequestBody SignUpRequest request) {
        SignUpResponse response = new SignUpResponse();
        return response;
    }

    // move from class "GetAgentController"
    @GetMapping(value = "/get-patient-detail-by-mobile")
    public SignUpResponse patientDetail(@RequestBody SignUpRequest request) {
        SignUpResponse response = new SignUpResponse();
        return response;
    }

    @PostMapping(value = "/fill-up-detail")
    public ResponseEntity<PatientFillUpResponse> fillupPatientDetail(@RequestBody PatientFillUpRequest request) {
        PatientFillUpResponse patientFillUpResponse = new PatientFillUpResponse();
        try {
            patientionService.fillUpDetail(request);
            patientFillUpResponse.success();
            return ResponseEntity.ok().body(patientFillUpResponse);
        } catch (Exception e) {
            e.printStackTrace();
            patientFillUpResponse.fail("9000",e.getMessage());
            return ResponseEntity.ok().body(patientFillUpResponse);
        }

    }



}
