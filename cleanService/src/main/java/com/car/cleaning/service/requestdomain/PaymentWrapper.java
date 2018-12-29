package com.car.cleaning.service.requestdomain;

import com.car.cleaning.common.Amount;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by jiangyunfan on 2018/12/29.
 */
@Setter
@Getter
public class PaymentWrapper {

    private Long facilityId;
    private Long storeId;
    //Optional
    private Long incentiveId;
    //Optional
    private Long payId;
    private String carIndicator;
    private String paymentAccountId;
    //Optional
    private String paymentMethod;
    //Optional
    private Long userId;
    private Amount amount;
}
