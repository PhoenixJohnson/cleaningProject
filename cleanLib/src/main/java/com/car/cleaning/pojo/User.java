package com.car.cleaning.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
@EntityListeners(AuditingEntityListener.class)
@Table(name = "CC_User", indexes = {
        @Index(name = "cc_user_sex_index", columnList = "sex"),
        @Index(name = "cc_user_phone_index", columnList = "phone"),
        @Index(name = "cc_user_emailAddress_index", columnList = "emailAddress"),
        @Index(name = "cc_user_userPaymentAccount_index", columnList = "userPaymentAccount"),
        @Index(name = "cc_user_active_index", columnList = "active"),
        @Index(name = "cc_user_creationDate_index", columnList = "creationDate DESC"),
        @Index(name = "cc_user_lastModifiedDate_index", columnList = "lastModifiedDate DESC"),
})
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class User extends BaseBo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userId_seq")
    @SequenceGenerator(name = "userId_seq", allocationSize = 1, initialValue = 5000000, sequenceName = "userId_seq")
    @Column(nullable = false, insertable = false, updatable = false)
    private Long userId;

    @Column(nullable = false, unique = true)
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

    private boolean isGuest;

    @Min(0)
    @Max(200)
    @Column(columnDefinition = "TINYINT(1) default '0'")
    private int age;

    @Column(nullable = false, length = 32)
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
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(nullable = false)
    private Date lastModifiedDate;

}
