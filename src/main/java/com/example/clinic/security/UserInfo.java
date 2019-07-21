package com.example.clinic.security;

import com.example.clinic.module.Patiention.model.PatientFillUpRequest;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserInfo {


    private String name;

    private String username;

    private Long salary;

    private String role;

    private String address;

    private Date startDate;

}
