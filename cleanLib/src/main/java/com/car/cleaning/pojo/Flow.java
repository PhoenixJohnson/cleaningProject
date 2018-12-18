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
@Setter
@Getter
@Entity
@Table(name = "CC_Flow", indexes = {
        @Index(name="cc_flow_storeId_index", columnList = "storeId"),
        @Index(name="cc_flow_userId_index", columnList = "userId"),
        @Index(name="cc_flow_carId_index", columnList = "carId"),
        @Index(name="cc_flow_facilityId_index", columnList = "facilityId"),
        @Index(name="cc_flow_payId_index", columnList = "payId"),
        @Index(name="cc_flow_facilityMethod_index", columnList = "facilityMethod"),
        @Index(name="cc_flow_awaitingTimePeriod_index", columnList = "awaitingTimePeriod"),
        @Index(name="cc_flow_enterTime_index", columnList = "enterTime"),
        @Index(name="cc_flow_leaveTime_index", columnList = "leaveTime"),
        @Index(name="cc_flow_executeTime_index", columnList = "executeTime"),
        @Index(name="cc_flow_flowDate_index", columnList = "flowDate"),
        @Index(name="cc_flow_creationDate_index", columnList = "creationDate"),
        @Index(name="cc_flow_lastModifiedDate_index", columnList = "lastModifiedDate")
})
public class Flow extends BaseBo{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long flowId;

    @Column(nullable = false)
    private Long storeId;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long carId;

    @Column(nullable = false)
    private Long facilityId;

    @Column(nullable = false)
    private Long payId;

    @Column(length = 256)
    private String facilityMethod;

    @Column(precision = 1, scale = 1)
    private float navigationTimePeriod;

    @Column(precision = 1, scale = 1)
    private float awaitingTimePeriod;

    @Temporal(TemporalType.TIMESTAMP)
    private Date enterTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date leaveTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date executeTime;

    @Min(1)
    @Max(9)
    @Column(columnDefinition = "TINYINT(1) default '9'")
    private int score;

    @Temporal(TemporalType.DATE)
    private Date flowDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date lastModifiedDate;


}
