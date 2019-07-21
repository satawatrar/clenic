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
@Table(name = "Bill")
public class BillEntity implements Serializable {

    @Id
    @Column(name = "BILL_ID", nullable = false)
    private Long billId;

    @Column(name = "BILL_CODE", nullable = false)
    private Long clinicId;

    @Column(name = "EXM_ID", nullable = false)
    private Long doctorId;

    @ManyToOne(optional=false)
    @JoinColumn(name="staffId",referencedColumnName="EMP_ID")
    private EmployeeEntity staffEntity;

    @Column(name = "BILL_DATE", nullable = false)
    private Date aptDate;

    @Column(name = "STATUS", nullable = false)
    private String stataus;

    @Column(name = "CREATED_DATE", nullable = false)
    private Date createdDate;

    @Column(name = "CREATED_BY", nullable = false)
    private String createdBy;

    @Column(name = "UPDATED_DATE", nullable = false)
    private Date updatedDate;

    @Column(name = "UPDATED_BY", nullable = false)
    private String updatedBy;



}
