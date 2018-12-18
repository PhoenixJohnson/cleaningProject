package com.car.cleaning.core.manager;

import com.car.cleaning.bo.FlowBo;
import com.car.cleaning.bo.PaymentBo;
import com.car.cleaning.bo.UserBo;
import com.car.cleaning.dalinterface.*;
import com.car.cleaning.pojo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jiangyunfan on 2018/12/18.
 */
@Component
@Slf4j
public class PaymentManager {


    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private FacilityRepository facilityRepository;

    @Autowired
    private FlowRepository flowRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StoreRepository storeRepository;


    public PaymentBo findPaymentDetails(Long payId) {

        PaymentBo paymentBo = new PaymentBo();
        UserBo userBo = new UserBo();
        List<FlowBo> flowBos = new ArrayList<>();
        try {
            //找到最原始payment记录
            Payment payment = paymentRepository.findById(payId).get();
            //知道到对应Flows记录
            List<Flow> flows = flowRepository.findFlowsByPayId(payId);
            for(Flow flow: flows) {
                //根据flows内容，关联机器
                FlowBo flowBo = new FlowBo(flow, facilityRepository.findById(flow.getFacilityId()).get());
                flowBos.add(flowBo);
            }
            //找到支付的原始User信息
            User user = userRepository.findById(payment.getUserId()).get();
            Car car = carRepository.findById(payment.getCarId()).get();
            userBo.setCars(Arrays.asList(car));
            userBo.setUser(user);

            //找到店铺信息
            Store store = storeRepository.findById(payment.getStoreId()).get();

            //组装信息集合
            paymentBo.setFlowBos(flowBos);
            paymentBo.setStore(store);
            paymentBo.setUser(userBo);
            paymentBo.setPayment(payment);


        } catch (Exception e) {
            log.error("查询支付记录失败:{}", e.getMessage());
        }

        return paymentBo;


    }

}
