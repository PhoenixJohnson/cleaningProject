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
@Table(name = "CC_Store")
public class Store {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long storeId;
    private String storeOwnerName;
    private String storeOwnerPhone;
    private String storeAddress;
    private int active;
    private int level;
    private String storePaymentAccount;
    private float runPeriod;
    private double authAmount;
    private Date creationDate;
    private Date lastModifiedDate;

}
