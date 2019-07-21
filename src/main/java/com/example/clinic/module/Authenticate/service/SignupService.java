package com.example.clinic.module.Authenticate.service;


//import com.example.clinic.module.Authenticate.model.SignOn;

import com.example.clinic.domain.EmployeeEntity;
import com.example.clinic.module.Authenticate.model.SignUpRequest;
import com.example.clinic.module.Authenticate.model.SignUpResponse;
import com.example.clinic.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class SignupService {

    private EmployeeRepository employeeRepository;

    private static final String  DEFAULT_ROLE = "ADMIN";

    @Transactional
    public SignUpResponse signUp(SignUpRequest request) {
        try {
            EmployeeEntity employeeEntity = new EmployeeEntity();
            employeeEntity.setName(request.getName());
            employeeEntity.setRole(request.getRole());
            employeeEntity.setPassword(request.getPassword());
            employeeEntity.setUsername(request.getUsername());
            employeeEntity.setAddress(request.getAddress());

            employeeRepository.saveAndFlush(employeeEntity);
        } catch (Exception e) {
            System.out.println("Ca : " + e.getCause());
            throw e;
        }
        SignUpResponse response = new SignUpResponse();
        response.success();
        return response;
    }
}
