package com.car.cleaning.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by jiangyunfan on 2018/11/20.
 */
@Setter
@Getter
@Entity
@Table(name = "CC_Car", indexes = {
        @Index(name="cc_car_userId_index",columnList = "userId"),
        @Index(name="cc_car_carIndicator_index",columnList = "carIndicator"),
        @Index(name="cc_car_size_index",columnList = "size"),
        @Index(name="cc_car_creationDate_index",columnList = "creationDate"),
        @Index(name="cc_car_lastModifiedDate_index",columnList = "lastModifiedDate")
})
public class Car extends BaseBo{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long carId;

    @Column(nullable = false)
    private Long userId;

    @Column(length = 32, nullable = false)
    private String carIndicator;

    @Column(length = 32, nullable = false)
    private String carModel;

    @Column(length = 64, nullable = false)
    private String carBrand;

    @Min(0)
    @Max(20)
    @Column(columnDefinition = "TINYINT(2) default '0'")
    private int carAge;

    @Column(length = 32, nullable = false)
    private String externalColor;

    @Column(length = 32)
    private String internalColor;

    @Min(0)
    @Max(20)
    @Column(columnDefinition = "TINYINT(2) default '0'")
    private int size;

    @Column(columnDefinition = "BLOB")
    private HashMap<String, String> additionalData;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date lastModifiedDate;

}
