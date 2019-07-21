package com.example.clinic.module.Patiention.model;


import com.example.clinic.common.BaseResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public
class PatientFillUpResponse extends BaseResponse {

}
