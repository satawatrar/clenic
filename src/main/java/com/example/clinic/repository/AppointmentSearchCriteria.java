package com.example.clinic.repository;

import lombok.Data;

import java.util.Date;

@Data
public class AppointmentSearchCriteria {

    Long empId;
    Date reserveTime;

}
