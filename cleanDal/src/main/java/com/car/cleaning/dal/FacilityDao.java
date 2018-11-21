package com.car.cleaning.dal;


import com.car.cleaning.dalinterface.FacilityRepository;
import com.car.cleaning.pojo.Facility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by jiangyunfan on 2018/11/20.
 */
@Component
public class FacilityDao {

    @Autowired
    private FacilityRepository repository;

    public Facility findFacilityById(Long facilityId) {
        Optional<Facility> facility = repository.findById(facilityId);
        return facility.get();

    }

}
