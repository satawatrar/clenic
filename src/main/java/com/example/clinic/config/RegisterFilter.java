package com.example.clinic.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class RegisterFilter {

    @Bean
    public FilterRegistrationBean<TransactionFilter> loggingFilter(){
        FilterRegistrationBean<TransactionFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new TransactionFilter());
        registrationBean.addUrlPatterns("/login");
        return registrationBean;
    }

}