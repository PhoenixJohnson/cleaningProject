package com.car.cleaning.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

/**
 * Created by jiangyunfan on 2018/11/20.
 */
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "CC_Payment", indexes = {
        @Index(name="cc_payment_storeId_index", columnList = "storeId"),
        @Index(name="cc_payment_userId_index", columnList = "userId"),
        @Index(name="cc_payment_carId_index", columnList = "carId"),
        @Index(name="cc_payment_paymentMethod_index", columnList = "paymentMethod"),
        @Index(name="cc_payment_userPaymentAccount_index", columnList = "userPaymentAccount"),
        @Index(name="cc_payment_storePaymentAccount_index", columnList = "storePaymentAccount"),
        @Index(name="cc_payment_incentiveId_index", columnList = "incentiveId"),
        @Index(name="cc_payment_creationDate_index", columnList = "creationDate"),
        @Index(name="cc_payment_lastModifiedDate_index", columnList = "lastModifiedDate")
})
public class Payment extends BaseBo{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payId_seq")
    @SequenceGenerator(name="payId_seq",allocationSize=1,initialValue=5000000,sequenceName="payId_seq")
    private Long payId;

    @Column(nullable = false)
    private Long storeId;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long carId;

    @Column(length = 128)
    private String paymentMethod;

    @Column(length = 256)
    private String userPaymentAccount;

    @Column(length = 256)
    private String storePaymentAccount;

    @Column(precision = 4, scale = 2)
    private double payAmount;

    @Column
    private Long incentiveId;

    @Column(precision = 3, scale = 1)
    private double incentiveAmount;

    @Column(columnDefinition = "BLOB")
    private String payRequest;

    @Column(columnDefinition = "BLOB")
    private String payResponse;

    @Column(length = 256)
    private String cashPayToken;

    @Min(0)
    @Max(999)
    @Column(columnDefinition = "SMALLINT(3) default '0'")
    private int payStatus;

    @Column(length = 8192)
    private String paymentExternalEndPoint;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(nullable = false)
    private Date lastModifiedDate;

}
