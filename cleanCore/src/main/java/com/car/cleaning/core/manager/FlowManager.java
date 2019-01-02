package com.car.cleaning.core.manager;

import com.car.cleaning.bo.FlowBo;
import com.car.cleaning.core.manager.builder.FlowBuilder;
import com.car.cleaning.dalinterface.FacilityRepository;
import com.car.cleaning.dalinterface.FlowRepository;
import com.car.cleaning.exception.CleanErrorCode;
import com.car.cleaning.exception.CleanException;
import com.car.cleaning.pojo.Facility;
import com.car.cleaning.pojo.Flow;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangyunfan on 2018/12/18.
 */
@Component
@Slf4j
public class FlowManager {

    @Autowired
    private FacilityRepository facilityRepository;

    @Autowired
    private FlowRepository flowRepository;

    @Autowired
    private FlowBuilder flowBuilder;

    public List<FlowBo> createFlow(Long userId, Long carId, Long storeId, Long facilityId, Long paymentId) throws CleanException {

        if (userId == null || carId == null || facilityId == null || storeId == null || paymentId == null) {
            throw new CleanException(CleanErrorCode.VALIDATION_ERROR, "没有找到必要的关键字段，请确认传入参数是否有空值");
        }
        List<FlowBo> flowBos = new ArrayList<>();
        if (paymentId != null && paymentId > 0) {
            flowBos.addAll(flowBuilder.buildFlowBo(flowRepository.findFlowsByPayId(paymentId)));
        }
        flowBos.add(createFlowBo(userId, carId, storeId, facilityId, paymentId));

        return flowBos;
    }

    private FlowBo createFlowBo(Long userId, Long carId, Long storeId, Long facilityId, Long paymentId) throws CleanException {
        FlowBo flowBo = new FlowBo();
        Facility facility = facilityRepository.findById(facilityId).get();
        if (facility == null) {
            throw new CleanException(CleanErrorCode.DB_EXCEPTION, String.format("没有从数据库中找到对应设备信息:%s，请管理员进行查看", String.valueOf(facilityId)));
        }
        Flow flow = flowBuilder.buildFlowByIds(userId, carId, storeId, facilityId, paymentId);
        if (flow == null) {
            throw new CleanException(CleanErrorCode.DB_EXCEPTION, "创建Flow失败！请重试！");
        }
        flowBo.setFacility(facility);
        flowBo.setFlow(flow);
        return flowBo;
    }

}
