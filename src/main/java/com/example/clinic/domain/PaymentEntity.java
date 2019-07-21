package com.example.clinic.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Getter
@Setter
@ToString
@Table(name = "PAYMENT")
public class PaymentEntity implements Serializable {

    @Id
    @Column(name = "PAYMENT_ID", nullable = false)
    private Long paymentId;

    @Column(name = "PAYMENT_CODE", nullable = false)
    private String paymentCode;

    @ManyToOne(optional=false)
    @JoinColumn(name="patientId",referencedColumnName="PATIENT_ID")
    private PatientEntity patientEntity;

    @ManyToOne(optional=false)
    @JoinColumn(name="billId",referencedColumnName="BILL_ID")
    private BillEntity billEntity;

    @Column(name = "STATUS", nullable = false)
    private String status;

    @Column(name = "PAYMENT_DATE", nullable = false)
    private Date paymentDate;

    @Column(name = "CREATED_DATE", nullable = false)
    private Date createdDate;

    @Column(name = "CREATED_BY", nullable = false)
    private String createdBy;

    @Column(name = "UPDATED_DATE", nullable = false)
    private Date updatedDate;

    @Column(name = "UPDATED_BY", nullable = false)
    private String updatedBy;



}
