package com.car.cleaning.dal;


import com.car.cleaning.dalinterface.FlowRepository;
import com.car.cleaning.pojo.Flow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by jiangyunfan on 2018/11/20.
 */
@Component
public class FlowDao {

    @Autowired
    private FlowRepository flowRepository;

    public Flow findFlowById(Long flowId) {
        Optional<Flow> flow = flowRepository.findById(flowId);
        return flow.get();

    }

}
