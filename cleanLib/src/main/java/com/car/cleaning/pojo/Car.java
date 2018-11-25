package com.car.cleaning.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jiangyunfan on 2018/11/20.
 */
@Setter
@Getter
@Entity
@Table(name = "CC_Car")
public class Car {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long carId;
    private Long userId;
    private String carIndicator;
    private String carModel;
    private String carBrand;
    private int carAge;
    private int externalColor;
    private int internalColor;
    private int size;
    private String additionalData;
    private Date creationDate;
    private Date lastModifiedDate;

}
