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
@Table(name = "STOCK")
public class StockEntity implements Serializable {

    @Id
    @Column(name = "STOCK_ID", nullable = false)
    private Long stockId;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "TYPE", nullable = false)
    private String type;

    @Column(name = "BRAND", nullable = false)
    private String brand;

    @Column(name = "STOCK_SIZE", nullable = false)
    private String stockSize;

    @Column(name = "STOCK_SIZE_UNIT", nullable = false)
    private String stockSizeUnit;

    @Column(name = "STOCK_COST", nullable = false)
    private Double stockCost;

    @Column(name = "STOCK_COST_UNIT", nullable = false)
    private String stockCostUnit;

    @Column(name = "BUY_DATE", nullable = false)
    private Date buyDate;

    @Column(name = "EXP_DATE", nullable = false)
    private Date expDate;

    @Column(name = "IS_STEALED", nullable = false)
    private String isStealed;

    @Column(name = "AMOUNT", nullable = false)
    private Long amount;



}
