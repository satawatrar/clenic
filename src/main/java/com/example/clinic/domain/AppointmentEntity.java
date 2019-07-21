package com.example.clinic.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@ToString
@Table(name = "APPOINTMENT")
public class AppointmentEntity implements Serializable {

    @Id
    @Column(name = "APT_ID", nullable = false)
    private Long aptId;

    @Column(name = "CLINIC_ID", nullable = false)
    private Long clinicId;

    @Column(name = "DOCTOR_ID", nullable = false)
    private Long doctorId;

    @Column(name = "PATIENT_ID", nullable = false)
    private Long patientId;

    @Column(name = "APT_DATE", nullable = false)
    private Timestamp aptDate;

    @Column(name = "START_TIME", nullable = false)
    private Timestamp startTime;

    @Column(name = "END_TIME", nullable = false)
    private Timestamp endTime;


    @Column(name = "STATUS", nullable = false)
    private String stataus;


}
