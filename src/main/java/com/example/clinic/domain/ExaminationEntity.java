package com.example.clinic.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;

@Entity
@Getter
@Setter
@ToString
@Table(name = "EXAMINATION")
public class ExaminationEntity implements Serializable {

    @Id
    @Column(name = "EXM_ID", nullable = false)
    private Long exmId;

    @Column(name = "APT_ID", nullable = false)
    private Long aptId;

    @Column(name = "FACE_BF_IMG", nullable = false)
    private Blob faceBfImg;

    @Column(name = "FACE_ZOOM_IMG", nullable = false)
    private Blob faceZoomImg;

    @Column(name = "MED_IMG", nullable = false)
    private Blob medImg;

    @Column(name = "MED_AMT", nullable = false)
    private Double medAmt;

    @Column(name = "MED_BRAND", nullable = false)
    private Double medBrand;

    @Column(name = "STOCK_ID", nullable = false)
    private Double stockId;

    @Column(name = "EXAM_DATE", nullable = false)
    private Date examDate;

    @Column(name = "STATUS", nullable = false)
    private String status;

    @Column(name = "ANESTHESIA", nullable = false)
    private String anesthesia;

    @Column(name = "FACE_ZOOM_BF_IMG", nullable = false)
    private Blob faceZoomBfImg;



}
