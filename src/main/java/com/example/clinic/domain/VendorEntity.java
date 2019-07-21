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
@Table(name = "VENDOR")
public class VendorEntity implements Serializable {

    @Id
    @Column(name = "VENDOR_ID", nullable = false)
    private Long doctorId;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "PRODUCT_NAME", nullable = false)
    private String productName;

    @Column(name = "START_DATE", nullable = false)
    private Date startDate;

    @Column(name = "END_DATE", nullable = false)
    private Date endDate;

    @Column(name = "STATUS", nullable = false)
    private String status;


}
