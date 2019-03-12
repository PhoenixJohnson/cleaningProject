package com.car.cleaning.core.manager;

import com.car.cleaning.core.manager.builder.CommonConstant;
import com.car.cleaning.core.validation.ValidationGateWay;
import com.car.cleaning.core.validation.ValidationPhase;
import com.car.cleaning.dalinterface.FacilityRepository;
import com.car.cleaning.pojo.Facility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by jiangyunfan on 2018/12/18.
 */
@Component
@Slf4j
public class FacilityManager {


    @Autowired
    private FacilityRepository facilityRepository;

    @Autowired
    private ValidationGateWay validationGateWay;

    public Facility findOrCreateFacility(Facility facility) {

        validationGateWay.validateFacility(facility, ValidationPhase.CREATE_FACILITY);
        try {
            if (facility.getFacilityId() != null) {
                return facilityRepository.findById(facility.getFacilityId()).orElse(null);
            }
        } catch (Exception e) {

        }
        Facility newFacility = new Facility();
        newFacility.setFacilityModel(facility.getFacilityModel());
        newFacility.setActiveDate(new Date());
        newFacility.setEmployAmount(facility.getEmployAmount());
        newFacility.setEmployCount(0);
        newFacility.setFacilityMaintainPeriod(facility.getFacilityMaintainPeriod() > 0 ? facility.getFacilityMaintainPeriod() : CommonConstant.FACILITY_MAINTAIN_DEFAULT_VALUE);
        newFacility.setFacilityPeriod(0f);
        newFacility.setLastMaintainDate(new Date());
        newFacility.setManufactureDate(facility.getManufactureDate());
        newFacility.setNextMaintainDays(facility.getNextMaintainDays() > 0 ? facility.getNextMaintainDays() : CommonConstant.FACILITY_DEFAULT_MAINTENANCE_DAYS);
        newFacility.setStoreId(facility.getStoreId());
        return facilityRepository.save(newFacility);

    }


    public List<Facility> findFacilitiesByStoreId(Long storeId) {
        return facilityRepository.findFacilitiesByStoreId(storeId);
    }

    public void deleteFacilityById(Long facilityId) {
        facilityRepository.deleteById(facilityId);
    }
}
