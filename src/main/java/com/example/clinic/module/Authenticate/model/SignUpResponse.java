package com.example.clinic.module.Authenticate.model;


import com.example.clinic.common.BaseResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SignUpResponse extends BaseResponse {


}
