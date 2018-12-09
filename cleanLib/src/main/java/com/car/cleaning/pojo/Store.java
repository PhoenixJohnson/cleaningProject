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
@Table(name = "CC_Store", indexes = {
        @Index(name="cc_store_storeOwnerName_index", columnList = "storeOwnerName"),
        @Index(name="cc_store_active_index", columnList = "active"),
        @Index(name="cc_store_level_index", columnList = "level"),
        @Index(name="cc_store_storePaymentAccount_index", columnList = "storePaymentAccount"),
        @Index(name="cc_store_runPeriod_index", columnList = "runPeriod"),
        @Index(name="cc_store_creationDate_index", columnList = "creationDate"),
        @Index(name="cc_store_lastModifiedDate_index", columnList = "lastModifiedDate")
})
public class Store extends BaseBo{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long storeId;

    @Column(nullable = false)
    private String storeOwnerName;

    @Column(nullable = false)
    private String storeOwnerPhone;

    @Column(nullable = false)
    private String storeAddress;

    @Min(0)
    @Max(2)
    @Column(columnDefinition = "TINYINT(1) default '0'")
    private int active;

    @Min(1)
    @Max(5)
    @Column(columnDefinition = "TINYINT(1) default '5'")
    private int level;

    @Column(nullable = false)
    private String storePaymentAccount;

    @Column(precision = 3, scale = 1)
    private float runPeriod;

    @Column(nullable = false, precision = 8, scale = 2)
    private double authAmount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date lastModifiedDate;

}
