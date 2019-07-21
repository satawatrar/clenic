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
@Table(name = "EMPLOYEE")
public class EmployeeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EMP_ID", nullable = false)
    private Long empId;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "SALARY", nullable = false)
    private Long salary;

    @Column(name = "ROLE", nullable = false)
    private String role;

    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @Column(name = "START_DATE", nullable = false)
    private Date startDate;

    @Column(name = "END_DATE", nullable = false)
    private Date endDate;

    @PrePersist
    public void prePersist() {
        startDate  = new Date();
    }

//    @PreUpdate
//    public void preUpdate() {
//        updatedOn = LocalDateTime.now();
//        updatedBy = LoggedUser.get();
//    }

}
