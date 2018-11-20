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
public class Flow {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long flowId;
    private Long storeId;
    private Long userId;
    private Long carId;
    private Long facilityId;
    private Long payId;
    private String facilityMethod;
    private float navigationTimePeriod;
    private float awaitingTimePeriod;
    private Date enterTime;
    private Date leaveTime;
    private Date executeTime;
    private int score;
    //yyyy-MM-dd
    private String flowDate;


}
