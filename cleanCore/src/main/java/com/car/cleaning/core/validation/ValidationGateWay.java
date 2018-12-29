package com.car.cleaning.core.validation;

import com.car.cleaning.common.Amount;
import com.car.cleaning.pojo.Car;
import com.car.cleaning.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class ValidationGateWay extends BaseValidation {

    public void validateUser(Long userId, ValidationPhase phase) {

    }

    public void validateUser(User user, ValidationPhase phase) {

    }

    public void validateCar(Long carId, ValidationPhase phase) {

    }

    public void validateCar(Car car, ValidationPhase phase) {

    }

    public void validateFacility(Long facilityId, ValidationPhase phase) {

    }

    public void validateStore(Long storeId, ValidationPhase phase) {

    }

    public void validateAmount(Amount amount) {

    }


}
