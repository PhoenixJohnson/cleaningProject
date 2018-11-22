package com.car.cleaning.dal;


import com.car.cleaning.dalinterface.IncentiveRepository;
import com.car.cleaning.pojo.Incentive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by jiangyunfan on 2018/11/20.
 */
@Component
public class IncentiveDao {

    @Autowired
    private IncentiveRepository incentiveRepository;

    public Incentive findIncentiveById(Long incentiveId) {
        Optional<Incentive> incentive = incentiveRepository.findById(incentiveId);
        return incentive.get();

    }

}
