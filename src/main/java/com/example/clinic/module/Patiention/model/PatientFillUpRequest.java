package com.example.clinic.module.Patiention.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.sql.Date;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)
public class PatientFillUpRequest {

    @NotNull
    private String thaiId;

    @NotNull
    private String password;

    @NotNull
    private String name;

    @NotNull
    private String nickName;

    @NotNull
    private String sex;

    @NotNull
    private Long age;

    @NotNull
    private String dob;

    @NotNull
    private String address;

    private String email;

    @NotNull
    private String mobileNo;

    private String lineNo;

    private String medicalHistory;

    private String drugUsed;

    private String drugAllergy;

    private String faceImg;


}
