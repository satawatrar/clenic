package com.example.clinic.repository;

import lombok.Data;

import java.util.Date;

@Data
public class DoctorScheduleSearchCriteria {

    Long empId;
    Long bId;
    String date;
    Date reserveTime;

}
