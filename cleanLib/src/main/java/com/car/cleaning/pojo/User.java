package com.car.cleaning.pojo;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by jiangyunfan on 2018/11/19.
 */
@Setter
@Getter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long userId;
    private String userName;
    private String password;
    private String externalLoginIndicator;
    private String externalLoginToken;
    private int sex;
    private int age;
    private String phone;
    private String emailAddress;
    private String userPaymentAccount;
    private int active;
    private Date creationDate;
    private Date lastModifiedDate;

}
