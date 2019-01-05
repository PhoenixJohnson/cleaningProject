package com.car.cleaning.console.resource;

import com.car.cleaning.console.chart.PaymentsReport;
import com.car.cleaning.rpc.CommonResponse;
import com.car.cleaning.rpc.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jiangyunfan on 2019/1/5.
 */
@Controller
@RequestMapping("/api/payment")
public class PaymentReportResource {

    @Autowired
    private PaymentsReport paymentsReport;

    /**
     * 获取当天实时现金流
     * 此接口必须有一定level人员才能获取
     * 第一实现方式，前台每过一段时间向后台请求数据
     * 第二阶段实现，后台按照服务器压力，向前台推送
     * @return
     */
    @RequestMapping(value = "/getPaymentsRT",
            method = RequestMethod.GET)
    public ResponseEntity<CommonResponse> getLatestDayPaymentRT() {
        try {
            return new ResponseEntity<>(ResponseBuilder.buildResponseObj(paymentsReport.getLatestDayPayments(), true), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(ResponseBuilder.buildShortMessageResponse(e.getMessage(), false), HttpStatus.OK);
        }

    }
}
