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
@Table(name = "CC_Incentive", indexes = {
        @Index(name="cc_incentive_storeId_index", columnList = "incentiveCode"),
        @Index(name="cc_incentive_creationDate_index", columnList = "creationDate"),
        @Index(name="cc_incentive_lastModifiedDate_index", columnList = "lastModifiedDate")
})
public class Incentive extends BaseBo{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long incentiveId;

    @Column(nullable = false)
    private String incentiveCode;

    @Column(precision = 3, scale = 1)
    private double incentiveAmount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date activeDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date expireDate;

    @Min(0)
    @Max(1)
    @Column(columnDefinition = "TINYINT(1) default '0'")
    private int redeemStatus;

    @Column(length = 512)
    private String restriction;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(nullable = false)
    private Date lastModifiedDate;
}
