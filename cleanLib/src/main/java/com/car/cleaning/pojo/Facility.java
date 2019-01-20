package com.car.cleaning.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
@EntityListeners(AuditingEntityListener.class)
@Table(name = "CC_Facility", indexes = {
        @Index(name="cc_facility_storeId_index", columnList = "storeId"),
        @Index(name="cc_facility_nextMaintainDays_index", columnList = "nextMaintainDays"),
        @Index(name="cc_facility_lastMaintainDate_index", columnList = "lastMaintainDate"),
        @Index(name="cc_facility_employAmount_index", columnList = "employAmount"),
        @Index(name="cc_facility_employCount_index", columnList = "employCount"),
        @Index(name="cc_facility_status_index", columnList = "status"),
        @Index(name="cc_facility_netStatus_index", columnList = "netStatus"),
        @Index(name="cc_facility_manufactureDate_index", columnList = "manufactureDate"),
        @Index(name="cc_facility_activeDate_index", columnList = "activeDate"),
        @Index(name="cc_facility_creationDate_index", columnList = "creationDate"),
        @Index(name="cc_facility_lastModifiedDate_index", columnList = "lastModifiedDate")
})
public class Facility extends BaseBo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "facilityId_seq")
    @SequenceGenerator(name="facilityId_seq",allocationSize=1,initialValue=5000000,sequenceName="facilityId_seq")
    private Long facilityId;

    @Column(nullable = false)
    private Long storeId;

    //店铺名
    @Column(length =128)
    private String storeName;

    @Column(length =128)
    private String facilityModel;

    @Column(precision = 1, scale = 1)
    private float facilityPeriod;

    @Column(precision = 1, scale = 1)
    private float facilityMaintainPeriod;

    @Min(1)
    @Max(1000)
    @Column(columnDefinition = "SMALLINT(4) default '1'")
    private int nextMaintainDays;

    @Temporal(TemporalType.DATE)
    private Date lastMaintainDate;

    //申请设备保证金
    @Column(precision = 6, scale = 2)
    private double employAmount;

    /**
     * 机器状态，运行良好、运行警告、运行错误
     */
    @Column(length = 32)
    private String status;

    /**
     * 网络连接状态，网络不可用、网络良好
     */
    @Column(length = 32)
    private String netStatus;

    @Min(0)
    @Max(999999)
    @Column(columnDefinition = "SMALLINT(6) default '0'")
    private int employCount;

    @Temporal(TemporalType.DATE)
    private Date manufactureDate;

    @Temporal(TemporalType.DATE)
    private Date activeDate;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(nullable = false)
    private Date lastModifiedDate;
}
