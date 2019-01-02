package com.car.cleaning.core.manager;

import com.car.cleaning.bo.FlowBo;
import com.car.cleaning.bo.PaymentBo;
import com.car.cleaning.bo.UserBo;
import com.car.cleaning.common.Amount;
import com.car.cleaning.common.PaymentMethod;
import com.car.cleaning.core.validation.ValidationGateWay;
import com.car.cleaning.core.validation.ValidationPhase;
import com.car.cleaning.dalinterface.*;
import com.car.cleaning.exception.CleanErrorCode;
import com.car.cleaning.exception.CleanException;
import com.car.cleaning.pojo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
    private IncentiveRepository incentiveRepository;

    @Autowired
    private StoreManager storeManager;

    @Autowired
    private ValidationGateWay validationGateWay;

    @Autowired
    private FlowManager flowManager;

    @Autowired
    private UserManager userManager;

    @Autowired
    private CarManager carManager;

    public PaymentBo findPaymentDetails(Long payId) {

        PaymentBo paymentBo = new PaymentBo();
        UserBo userBo = new UserBo();
        List<FlowBo> flowBos = new ArrayList<>();
        try {
            //找到最原始payment记录
            Payment payment = paymentRepository.findById(payId).get();
            //知道到对应Flows记录
            List<Flow> flows = flowRepository.findFlowsByPayId(payId);
            for (Flow flow : flows) {
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
            Store store = storeManager.findStoreById(payment.getStoreId());

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

    /**
     * 创建支付信息前，首先要确保信息取得渠道是否从业务角度可行
     * 从用户第一次扫二维码的时候，系统应该已经创建对应该台facility设备的session信息，之后用户的session会一直存在
     * @param userId user信息可以为空对象，之后会创建guest user，如果已经是用户，从扫二维码的时候get到用户信息，并且pass到session中
     * @param facilityId 静态二维码中包含字段
     * @param storeId 静态二维码中包含字段
     * @param payId 用户第一次扫描二维码为空，第二次扫二维码，会通过 facilityId + storeId + timestamp 来从session中获取payId（因为已经创建）
     * @param paymentAccount 用户扫描二维码的时候，由支付宝，微信或者第三方支付渠道提供付款者账户名
     * @param incentiveId 优惠券id，非必要选项
     * @param paymentMethod 支付方式，由支付扫码客户端提供 - AliPay/PayPal/WeChatPay ...
     * @param amount 支付金额
     * @param carIndicator 车牌号，需要用来去创建car信息，后台创建guest car/find car
     * @return
     * @throws CleanException
     */
    @Transactional
    public PaymentBo createPaymentBo(Long userId, Long facilityId, Long storeId, Long payId, String paymentAccount, Long incentiveId, PaymentMethod paymentMethod, Amount amount, String carIndicator) throws CleanException {
        PaymentBo paymentBo = new PaymentBo();
        //TODO VALIDATION IN AOP
        if (facilityId == null || storeId == null || carIndicator == null || amount == null || paymentAccount == null) {
            throw new CleanException(CleanErrorCode.VALIDATION_ERROR, "没有找到必要的关键字段，请确认传入参数是否有正确或者为空值");
        }
        //检查金额信息
        validationGateWay.validateAmount(amount);
        //检查设备信息合法性
        validationGateWay.validateFacility(facilityId, ValidationPhase.CREATE_PAYMENT);
        //检查店铺信息合法性
        validationGateWay.validateStore(storeId, ValidationPhase.CREATE_PAYMENT);
        //设置store 实体信息
        paymentBo.setStore(storeManager.findStoreById(storeId));
        //动态生成User和car信息
        User user;
        if(userId == null) {
            user = userManager.createGuestUserOnFly(paymentAccount);
        } else {
            user = userManager.findUserById(userId);
        }
        if(user == null) {
            throw new CleanException(CleanErrorCode.VALIDATION_ERROR, "用户信息检索失败！");
        }
        Car car = carManager.createCarOnFly(carIndicator, user.getUserId());
        //检查用户传递数据完整性
        validationGateWay.validateCar(car, ValidationPhase.CREATE_PAYMENT);
        //检查车辆信息完整信息
        validationGateWay.validateUser(user, ValidationPhase.CREATE_PAYMENT);
        //查询用户与车辆相关信息
        paymentBo.setUser(userManager.findOrCreateUserBo(user, car, paymentAccount));
        //查询优惠券信息，如果存在
        if(incentiveId != null) {
            paymentBo.setIncentive(incentiveRepository.findById(incentiveId).get());
        }
        //如果pay id有值，将查询所有相关flow，然后记录到本次create flow中。
        //如果pay id是空值，需要通过DB 占位首先创建一个待定的payment
        if(payId == null || !paymentRepository.existsById(payId)) {
            Payment payment = paymentRepository.save(createPayment(paymentBo.getUser().getUser().getUserId(),
                    paymentBo.getUser().getCurrentCar().getCarId(),
                    storeId,
                    paymentMethod.name(),
                    paymentAccount,
                    paymentBo.getStore().getStorePaymentAccount(),
                    amount.getValue(),
                    paymentBo.getIncentive()));
            paymentBo.setFlowBos(flowManager.createFlow(user.getUserId(), car.getCarId(), storeId, facilityId, payment.getPayId()));
            paymentBo.setPayment(payment);
        } else {
            paymentBo.setFlowBos(flowManager.createFlow(user.getUserId(), car.getCarId(), storeId, facilityId, payId));
            paymentBo.setPayment(paymentRepository.findById(payId).get());
        }

        return paymentBo;

    }

    public Payment createPayment(Long userId, Long carId, Long storeId, String paymentMethod, String paymentAccountId, String storePaymentId, Double amount, Incentive incentive) {
        Payment payment = new Payment();
        payment.setCarId(carId);
        payment.setUserId(userId);
        payment.setStoreId(storeId);
        payment.setPaymentMethod(paymentMethod);
        payment.setUserPaymentAccount(paymentAccountId);
        payment.setStorePaymentAccount(storePaymentId);
        payment.setPayAmount(amount);
        if(incentive != null) {
            payment.setIncentiveId(incentive.getIncentiveId());
            payment.setIncentiveAmount(incentive.getIncentiveAmount());
        }
        return payment;
    }

}
