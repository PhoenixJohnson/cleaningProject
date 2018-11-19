package com.car.cleaning.pojo;


import com.car.cleaning.common.Sex;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by jiangyunfan on 2018/11/19.
 */
@Setter
@Getter
public class User {

    private Long userId;
    private String userName;
    private String password;
    private String externalLoginIndicator;
    private String externalLoginToken;
    private Sex sex;
    private int age;
    private String phone;
    private String emailAddress;
    private String userPaymentAccount;
    private int active;
    private Date creationDate;
    private Date lastModifiedDate;

}
