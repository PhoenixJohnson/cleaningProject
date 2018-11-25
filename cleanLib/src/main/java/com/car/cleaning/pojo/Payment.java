package com.car.cleaning.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jiangyunfan on 2018/11/20.
 */
@Getter
@Setter
@Entity
@Table(name = "CC_Payment")
public class Payment {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long payId;
    private Long storeId;
    private Long userId;
    private Long carId;
    private String paymentMethod;
    private String userPaymentAccount;
    private String storePaymentAccount;
    private double payAmount;
    private Long incentiveId;
    private double incentiveAmount;
    private String payRequest;
    private String payResponse;
    private String cashPayToken;
    private int payStatus;
    private String paymentExternalEndPoint;
    private Date creationDate;
    private Date lastModifiedDate;

}
