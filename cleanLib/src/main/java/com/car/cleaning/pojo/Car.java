package com.car.cleaning.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Map;

/**
 * Created by jiangyunfan on 2018/11/20.
 */
@Setter
@Getter
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long carId;
    private Long userId;
    private String carIndicator;
    private String carModel;
    private String carBrand;
    private int carAge;
    private int externalColor;
    private int internalColor;
    private int size;
    private Map<String,String> additionalData;
    private Date creationDate;
    private Date lastModifiedDate;

}
