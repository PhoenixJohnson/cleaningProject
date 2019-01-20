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
@Setter
@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "CC_Flow", indexes = {
        @Index(name="cc_flow_storeId_index", columnList = "storeId"),
        @Index(name="cc_flow_userId_index", columnList = "userId"),
        @Index(name="cc_flow_carId_index", columnList = "carId"),
        @Index(name="cc_flow_facilityId_index", columnList = "facilityId"),
        @Index(name="cc_flow_payId_index", columnList = "payId"),
        @Index(name="cc_flow_instrumentTag_index", columnList = "instrumentTag"),
        @Index(name="cc_flow_cleaningStatus_index", columnList = "cleaningStatus"),
        @Index(name="cc_flow_startTime_index", columnList = "startTime"),
        @Index(name="cc_flow_endTime_index", columnList = "endTime"),
        @Index(name="cc_flow_cleanTime_index", columnList = "cleanTime"),
        @Index(name="cc_flow_executeTime_index", columnList = "executeTime"),
        @Index(name="cc_flow_flowDate_index", columnList = "flowDate"),
        @Index(name="cc_flow_creationDate_index", columnList = "creationDate"),
        @Index(name="cc_flow_lastModifiedDate_index", columnList = "lastModifiedDate")
})
public class Flow extends BaseBo{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flowId_seq")
    @SequenceGenerator(name="flowId_seq",allocationSize=1,initialValue=5000000,sequenceName="flowId_seq")
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

    private Long facilityInstrumentId;

    @Column(length = 128)
    private String instrumentTag;

    @Column(precision = 4, scale = 2)
    private double amount;

    @Column(length =128)
    private double cleaningStatus;

    @Column(precision = 1, scale = 1)
    private float navigationTimePeriod;

    /**
     * 洗车时长，根据所选择套餐类型定时长
     */
    @Min(1)
    @Max(99)
    @Column(columnDefinition = "TINYINT default '10'")
    private int cleanTime;

    /**
     * 洗车开始时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    /**
     * 预计洗车结束时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date executeTime;

    @Min(1)
    @Max(9)
    @Column(columnDefinition = "TINYINT(1) default '9'")
    private int score;

//    @Temporal(TemporalType.DATE)
    private String flowDate;

    @Column(length = 128)
    private String customerComment;


    @Column(length = 64)
    private String operator;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(nullable = false)
    private Date lastModifiedDate;


}
