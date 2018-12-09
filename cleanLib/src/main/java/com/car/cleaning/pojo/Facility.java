package com.car.cleaning.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

/**
 * Created by jiangyunfan on 2018/11/20.
 */
@Getter
@Setter
@Entity
@Table(name = "CC_Facility", indexes = {
        @Index(name="cc_facility_storeId_index", columnList = "storeId"),
        @Index(name="cc_facility_nextMaintainDays_index", columnList = "nextMaintainDays"),
        @Index(name="cc_facility_lastMaintainDate_index", columnList = "lastMaintainDate"),
        @Index(name="cc_facility_employAmount_index", columnList = "employAmount"),
        @Index(name="cc_facility_employCount_index", columnList = "employCount"),
        @Index(name="cc_facility_manufactureDate_index", columnList = "manufactureDate"),
        @Index(name="cc_facility_activeDate_index", columnList = "activeDate"),
        @Index(name="cc_facility_creationDate_index", columnList = "creationDate"),
        @Index(name="cc_facility_lastModifiedDate_index", columnList = "lastModifiedDate")
})
public class Facility extends BaseBo {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long facilityId;

    @Column(nullable = false)
    private Long storeId;

    @Column(length =128)
    private String facilityModel;

    @Column(precision = 1, scale = 1)
    private float facilityPeriod;

    @Column(precision = 1, scale = 1)
    private float facilityMaintainPeriod;

    @Min(1)
    @Max(1000)
    @Column(columnDefinition = "TINYINT(4) default '1'")
    private int nextMaintainDays;

    @Temporal(TemporalType.DATE)
    private Date lastMaintainDate;

    @Column(precision = 6, scale = 2)
    private double employAmount;

    @Min(0)
    @Max(999999)
    @Column(columnDefinition = "TINYINT(6) default '0'")
    private int employCount;

    @Temporal(TemporalType.DATE)
    private Date manufactureDate;

    @Temporal(TemporalType.DATE)
    private Date activeDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date lastModifiedDate;
}
