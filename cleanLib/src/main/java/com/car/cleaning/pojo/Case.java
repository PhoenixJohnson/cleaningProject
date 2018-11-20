package com.car.cleaning.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by jiangyunfan on 2018/11/20.
 */
@Setter
@Getter
@Entity
public class Case {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long caseId;
    private Long payId;
    private Long storeId;
    private Long userId;
    private Long carId;
    private Long facilityId;
    private Long serverId;
    private int caseType;
    private String caseDesc;
    private String caseLog;

}
