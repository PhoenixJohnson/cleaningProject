package com.car.cleaning.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by jiangyunfan on 2018/11/20.
 */
@Setter
@Getter
@Entity
@Table(name = "CC_Case")
public class Case {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
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
