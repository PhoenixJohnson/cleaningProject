package com.car.cleaning.service.resources;

import com.car.cleaning.dalinterface.PaymentRepository;
import com.car.cleaning.dalinterface.UserRepository;
import com.car.cleaning.pojo.Payment;
import com.car.cleaning.pojo.User;
import com.car.cleaning.rpc.CommonResponse;
import com.car.cleaning.util.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by jiangyunfan on 2018/11/21.
 */
@Controller
@RequestMapping("/cc/api/v1")
public class PaymentResource {

    @Autowired
    private PaymentRepository paymentRepository;

    @RequestMapping(value= "/pay", method = RequestMethod.POST)
    public ResponseEntity<CommonResponse> createOrUpdatePayment(@RequestBody Payment payment) {
        try{
            return new ResponseEntity<>(ResponseBuilder.buildResponseObj(paymentRepository.save(payment), true), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(ResponseBuilder.buildShortMessageResponse(e.getMessage(), false), HttpStatus.OK);
        }
    }

    @RequestMapping(value= "/pay", method = RequestMethod.GET)
    public ResponseEntity<CommonResponse> findPaymentById(@RequestParam Long paymentId) {
        try{
            return new ResponseEntity<>(ResponseBuilder.buildResponseObj(paymentRepository.findById(paymentId), true), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(ResponseBuilder.buildShortMessageResponse(e.getMessage(), false), HttpStatus.OK);
        }
    }


}
