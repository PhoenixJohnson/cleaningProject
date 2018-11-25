package com.car.cleaning.pojo;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

/**
 * Created by jiangyunfan on 2018/11/19.
 */
@Setter
@Getter
@Entity
@Table(name = "CC_User", indexes = {
        @Index(name = "cc_user_sex_index", columnList = "sex"),
        @Index(name = "cc_user_phone_index", columnList = "phone"),
        @Index(name = "cc_user_emailAddress_index", columnList = "emailAddress"),
        @Index(name = "cc_user_userPaymentAccount_index", columnList = "userPaymentAccount"),
        @Index(name = "cc_user_active_index", columnList = "active"),
        @Index(name = "cc_user_creationDate_index", columnList = "creationDate DESC"),
        @Index(name = "cc_user_lastModifiedDate_index", columnList = "lastModifiedDate DESC"),
})
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, insertable = false, updatable = false)
    private Long userId;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(length = 512)
    private String externalLoginIndicator;

    @Column(length = 512)
    private String externalLoginToken;

    @Min(0)
    @Max(2)
    @Column(columnDefinition = "TINYINT(1) default '1'")
    private int sex;

    @Min(0)
    @Max(200)
    @Column(columnDefinition = "TINYINT(1) default '0'")
    private int age;

    @Column(nullable = false, length = 32, unique = true)
    private String phone;

    @Column(nullable = false, length = 256)
    private String emailAddress;

    @Column(nullable = false, length = 256)
    private String userPaymentAccount;

    @Min(0)
    @Max(2)
    @Column(columnDefinition = "TINYINT(1) default '0'")
    private int active;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date lastModifiedDate;

}
