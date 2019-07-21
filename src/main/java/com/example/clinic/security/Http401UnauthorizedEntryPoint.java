package com.example.clinic.security;


import com.example.clinic.ResponseStatus;
import com.example.clinic.untility.ObjectMapperUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Returns a 401 error code (Unauthorized) to the client.
 */
@Component
public class Http401UnauthorizedEntryPoint implements AuthenticationEntryPoint {


    /**
     * Always returns a 401 error code to the client.
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException arg2)
        throws IOException,
        ServletException {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setResponseCode(ResponseStatus.AUTHENTICATION_FAIL.getCode());
        exceptionResponse.setDeveloperMessage(ResponseStatus.AUTHENTICATION_FAIL.name());
        exceptionResponse.setDeveloperMessage(arg2.getMessage());
        String resultJson = ObjectMapperUtils.convertObjectToJSON(exceptionResponse);
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        response.getWriter().write(resultJson);
    }
}
