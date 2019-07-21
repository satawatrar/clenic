package com.example.clinic.common;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)
public class BaseResponse {
    public String responseCode;
    public String developerMessage;

    public void success() {
        responseCode = "0";
        developerMessage = "success";
    }

    public void fail(String responseCode, String developerMessage) {
        this.responseCode = responseCode;
        this.developerMessage = developerMessage;
    }
}
