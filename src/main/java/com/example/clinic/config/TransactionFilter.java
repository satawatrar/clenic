package com.example.clinic.config;


import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public class TransactionFilter implements Filter {
    @Override
    public void doFilter(
    ServletRequest request,
    ServletResponse response,
    FilterChain chain)throws IOException,ServletException
    {
        System.out.println("Inside Filter");
        HttpServletRequest req = (HttpServletRequest) request;
        chain.doFilter(request, response);
    }

    // other methods
}