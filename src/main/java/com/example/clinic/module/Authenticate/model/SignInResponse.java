package com.example.clinic.module.Authenticate.model;


import com.example.clinic.common.BaseResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SignInResponse extends BaseResponse {

    private String username;

    private String name;

    private String role;

    private String token;


}
