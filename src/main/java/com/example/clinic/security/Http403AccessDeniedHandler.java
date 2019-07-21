package com.example.clinic.security;

import com.example.clinic.ResponseStatus;
import com.example.clinic.untility.ObjectMapperUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sahawat on 27/5/2559.
 */
@Component
public class Http403AccessDeniedHandler implements AccessDeniedHandler {


    /**
     * Always returns a 403 error code to the client.
     */

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {

        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setResponseCode(ResponseStatus.AUTHENTICATION_FAIL.getCode());
        exceptionResponse.setDeveloperMessage(ResponseStatus.AUTHENTICATION_FAIL.name());
        exceptionResponse.setDeveloperMessage(e.getMessage());
        String resultJson = ObjectMapperUtils.convertObjectToJSON(exceptionResponse);
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        response.getWriter().write(resultJson);
    }

}
