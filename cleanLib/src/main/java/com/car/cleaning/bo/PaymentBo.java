package com.car.cleaning.bo;

import com.car.cleaning.pojo.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by jiangyunfan on 2018/12/18.
 */
@Setter
@Getter
public class PaymentBo {

    private Payment payment;
    private List<FlowBo> flowBos;
    private UserBo user;
    private Store store;

}
