package com.example.clinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@EnableJpaRepositories
@PropertySources({
        @PropertySource(value = {"classpath:application.yml"}, ignoreResourceNotFound = true),
        @PropertySource(value = {"classpath:appInfo.properties"}, ignoreResourceNotFound = true),
})
public class ClinicApplication extends WebMvcConfigurerAdapter {
    public static void main(String[] args) {
        SpringApplication.run(ClinicApplication.class, args);

    }


//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new RequestInterceptor()).excludePathPatterns("/api/version");
//    }

}
