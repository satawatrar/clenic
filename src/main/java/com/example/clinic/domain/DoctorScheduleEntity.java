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
import java.sql.Time;

@Entity
@Getter
@Setter
@ToString
@Table(name = "DOCTOR_SCHEDULE")
public class DoctorScheduleEntity implements Serializable {

    @Id
    @Column(name = "DS_ID", nullable = false)
    private Long dsId;

    @Column(name = "BRANCH_ID", nullable = false)
    private Long bId;

    @Column(name = "EMP_ID", nullable = false)
    private Long empId;

    @Column(name = "WORK_DATE", nullable = false)
    private String workDate;

    @Column(name = "START_TIME", nullable = false)
    private Time startTime;

    @Column(name = "END_TIME", nullable = false)
    private Time endTime;

    @Column(name = "NAME", nullable = false)
    private String name;

}
