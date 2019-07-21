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
@Table(name = "STOCK_ORDER")
public class StockOrderEntity implements Serializable {

    @Id
    @Column(name = "SO_ID", nullable = false)
    private Long soId;

    @Column(name = "PAYMENT_CODE", nullable = false)
    private String paymentCode;

    @ManyToOne(optional=false)
    @JoinColumn(name="stockId",referencedColumnName="STOCK_ID")
    private StockEntity stockEntity;

    @ManyToOne(optional=false)
    @JoinColumn(name="staffId",referencedColumnName="EMP_ID")
    private EmployeeEntity staffEntity;

    @ManyToOne(optional=false)
    @JoinColumn(name="vendorId",referencedColumnName="VENDOR_ID")
    private VendorEntity vendorEntity;

    @Column(name = "STATUS", nullable = false)
    private String status;

    @Column(name = "ORDER_DATE", nullable = false)
    private Date orderDate;

    @Column(name = "CREATED_DATE", nullable = false)
    private Date createdDate;

    @Column(name = "CREATED_BY", nullable = false)
    private String createdBy;

    @Column(name = "UPDATED_DATE", nullable = false)
    private Date updatedDate;

    @Column(name = "UPDATED_BY", nullable = false)
    private String updatedBy;



}
