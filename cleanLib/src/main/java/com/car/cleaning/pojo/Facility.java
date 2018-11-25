package com.car.cleaning.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jiangyunfan on 2018/11/20.
 */
@Getter
@Setter
@Entity
@Table(name = "CC_Facility")
public class Facility {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
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
