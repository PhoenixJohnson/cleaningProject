package com.car.cleaning.core.manager.builder;

import com.car.cleaning.bo.FlowBo;
import com.car.cleaning.dalinterface.FacilityRepository;
import com.car.cleaning.dalinterface.FlowRepository;
import com.car.cleaning.pojo.Facility;
import com.car.cleaning.pojo.Flow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class FlowBuilder {

    @Autowired
    private FlowRepository flowRepository;

    @Autowired
    private FacilityRepository facilityRepository;

    public Flow buildFlowByIds(Long userId, Long carId, Long storeId, Long facilityId, Long paymentId) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Flow flow = new Flow();
        flow.setUserId(userId);
        flow.setCarId(carId);
        flow.setFacilityId(facilityId);
        flow.setStoreId(storeId);
        flow.setPayId(paymentId);
        flow.setFlowDate(format.format(new Date()));
        return flowRepository.save(flow);
    }

    public List<FlowBo> buildFlowBo(List<Flow> flows) {
        List<FlowBo> flowBoList = new ArrayList<>();
        for(Flow flow: flows) {
            FlowBo flowBo = new FlowBo();
            Facility facility = facilityRepository.findById(flow.getFacilityId()).get();
            flowBo.setFacility(facility);
            flowBo.setFlow(flow);
            flowBoList.add(flowBo);
        }
        return flowBoList;
    }
}
