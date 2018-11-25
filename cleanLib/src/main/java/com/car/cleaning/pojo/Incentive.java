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
@Table(name = "CC_Incentive")
public class Incentive {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long incentiveId;
    private String incentiveCode;
    private double incentiveAmount;
    private Date activeDate;
    private Date expireDate;
    private int redeemStatus;
    private String restriction;
}
