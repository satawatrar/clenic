package com.example.clinic.module.Common.controller;

import com.example.clinic.module.Authenticate.model.SignUpRequest;
import com.example.clinic.module.Authenticate.model.SignUpResponse;
import com.example.clinic.module.Common.model.DoctorScheduleRequest;
import com.example.clinic.module.Common.model.DoctorScheduleResponse;
import com.example.clinic.module.Common.service.CommonService;
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
public class Common {

    @Autowired
    CommonService commonService;

    @PostMapping(value = "/get-schedule")
    public ResponseEntity<DoctorScheduleResponse> getAgent(@RequestBody DoctorScheduleRequest request) {
        DoctorScheduleResponse response = new DoctorScheduleResponse();
        try {
            response =  commonService.getSchedule(request);
            response.success();
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            e.printStackTrace();
            response.fail("9000","Error");
            return ResponseEntity.ok().body(response);
        }
    }
}
