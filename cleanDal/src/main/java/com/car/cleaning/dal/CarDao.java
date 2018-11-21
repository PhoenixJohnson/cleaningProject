package com.car.cleaning.dal;


import com.car.cleaning.dalinterface.CarRepository;
import com.car.cleaning.pojo.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by jiangyunfan on 2018/11/20.
 */
@Component
public class CarDao {

    @Autowired
    private CarRepository repository;

    public Car findCarById(Long carId) {
        Optional<Car> car = repository.findById(carId);
        return car.get();

    }

}
