package com.car.cleaning.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by jiangyunfan on 2018/11/20.
 */
@Setter
@Getter
@Entity
public class Incentive {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long incentiveId;
    private String incentiveCode;
    private double incentiveAmount;
    private Date activeDate;
    private Date expireDate;
    private int redeemStatus;
    private String restriction;
}
