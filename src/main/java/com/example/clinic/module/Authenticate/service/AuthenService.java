package com.example.clinic.module.Authenticate.service;

import com.example.clinic.domain.EmployeeEntity;
import com.example.clinic.domain.PatientEntity;
import com.example.clinic.module.Authenticate.model.*;
import com.example.clinic.module.Patiention.model.PatientFillUpRequest;
import com.example.clinic.repository.EmployeeRepository;
import com.example.clinic.repository.PatientRepository;
import com.example.clinic.security.UserInfo;
import com.example.clinic.security.jwt.TokenProvider;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class AuthenService {

    private EmployeeRepository employeeRepository;

    @Autowired
    TokenProvider tokenProvider;

    private static final String DEFAULT_ROLE = "ADMIN";

    @Transactional
    public SignInResponse authenticate(SignInRequest request) throws Exception {
        SignInResponse response = new SignInResponse();
        EmployeeEntity employeeEntity = employeeRepository.findByUsername(request.getUsername()).orElseThrow(() -> new Exception("Data Not Found"));
        if (!employeeEntity.getPassword().equals(request.password)) {
            throw new Exception("Invalid data");
        }

        UserInfo userInfo = new UserInfo();

        userInfo.setUsername(employeeEntity.getUsername());
        userInfo.setName(employeeEntity.getName());
        userInfo.setRole(employeeEntity.getRole());
        userInfo.setAddress(employeeEntity.getAddress());
        userInfo.setSalary(employeeEntity.getSalary());


        response.setName(employeeEntity.getName());
        response.setUsername(employeeEntity.getUsername());
        response.setRole(employeeEntity.getRole());
        response.setToken(tokenProvider.builderJWT(userInfo, "CLINIC", false, 1800));
        response.success();

        return response;
    }


}
