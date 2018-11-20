package com.car.cleaning.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by jiangyunfan on 2018/11/20.
 */
@Getter
@Setter
@Entity
public class Facility {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long facilityId;
    private Long storeId;
    private String facilityModel;
    private float facilityPeriod;
    private float facilityMaintainPeriod;
    private int nextMaintainDays;
    private Date lastMaintainDate;
    private double employAmount;
    private int employCount;
    private Date manufactureDate;
    private Date activeDate;
    private Date creationDate;
    private Date lastModifiedDate;
}
