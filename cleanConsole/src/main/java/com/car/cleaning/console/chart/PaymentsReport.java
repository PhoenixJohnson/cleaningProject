package com.car.cleaning.console.chart;

import com.car.cleaning.core.manager.PaymentManager;
import com.car.cleaning.dalinterface.PaymentRepository;
import com.car.cleaning.pojo.Payment;
import com.car.cleaning.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by jiangyunfan on 2019/1/5.
 */
@Component
public class PaymentsReport {

    @Autowired
    private PaymentManager paymentManager;

    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> getLatestDayPayments() {
        Date startDate = DateUtil.getStartDate(Calendar.getInstance()).getTime();
        Date endDate = DateUtil.getEndDate(Calendar.getInstance()).getTime();
        return paymentRepository.findPaymentsByCreationDateBetween(startDate, endDate);

    }

}
