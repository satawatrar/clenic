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

@Entity
@Getter
@Setter
@ToString
@Table(name = "CLINIC")
public class ClinicEntity implements Serializable {

    @Id
    @Column(name = "CLINIC_ID", nullable = false)
    private Long clinicId;
    @Id
    @Column(name = "BRANCH_ID", nullable = false)
    private Long branchId;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "CREATED_DATE", nullable = false)
    private Date createdDate;

    @Column(name = "CREATED_BY", nullable = false)
    private String createdBy;

    @Column(name = "UPDATED_DATE", nullable = false)
    private Date updatedDate;

    @Column(name = "UPDATED_BY", nullable = false)
    private String updatedBy;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;


}
