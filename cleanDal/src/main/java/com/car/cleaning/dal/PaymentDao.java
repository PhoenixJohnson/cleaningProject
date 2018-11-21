package com.car.cleaning.dal;


import com.car.cleaning.dalinterface.PaymentRepository;
import com.car.cleaning.pojo.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by jiangyunfan on 2018/11/20.
 */
@Component
public class PaymentDao {

    @Autowired
    private PaymentRepository repository;

    public Payment findPaymentByid(Long paymentId) {
        Optional<Payment> payment = repository.findById(paymentId);
        return payment.get();

    }

}
