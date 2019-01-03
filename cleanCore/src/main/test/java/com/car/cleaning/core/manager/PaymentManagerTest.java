package com.car.cleaning.core.manager;

import com.car.cleaning.bo.PaymentBo;
import com.car.cleaning.common.Amount;
import com.car.cleaning.common.PaymentMethod;
import com.car.cleaning.exception.CleanException;
import com.google.gson.Gson;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by jiangyunfan on 2019/1/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:dalBeanConfig.xml")
public class PaymentManagerTest {

    @Autowired
    private PaymentManager paymentManager;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {


    }

    @Test
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
    public void testCreatePayment() throws CleanException {
        PaymentBo paymentBo = paymentManager.createPaymentBo(5000000L,5000000L,5000000L,null,"pay@alipay.com",null, PaymentMethod.ALIPAY,new Amount(30d,"RMB"),"沪C9Z778");
        Gson gson = new Gson();
        System.out.println(gson.toJson(paymentBo));
    }

}