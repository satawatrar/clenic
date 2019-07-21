package com.example.clinic.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Getter
@Setter
@ToString
@Table(name = "PATIENT")
public class PatientEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PATIENT_ID", nullable = false)
    private Long patientId;

    @Column(name = "THAI_ID", nullable = false)
    private String thaiId;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "NICK_NAME", nullable = false)
    private String nickName;

    @Column(name = "SEX", nullable = false)
    private String sex;

    @Column(name = "AGE", nullable = false)
    private Long age;

    @Column(name = "DOB", nullable = true)
    private Date dob;

    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @Column(name = "EMAIL", nullable = true)
    private String email;

    @Column(name = "MOBILE_NO", nullable = false)
    private String mobileNo;

    @Column(name = "LINE_ID", nullable = true)
    private String lineNo;

    @Column(name = "MEDICAL_HISTORY", nullable = true)
    private String medicalHistory;

    @Column(name = "DRUG_USED", nullable = true)
    private String drugUsed;

    @Column(name = "DRUG_ALLERGY", nullable = true)
    private String drugAllergy;

    @Column(name = "FACE_IMG", nullable = true)
    private String faceImg;


}
