package com.example.clinic.module.Authenticate.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public
class SignInRequest {

    public String username;

    public String password;


}
