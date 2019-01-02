package com.car.cleaning.core.manager;

import com.car.cleaning.core.validation.ValidationGateWay;
import com.car.cleaning.core.validation.ValidationPhase;
import com.car.cleaning.dalinterface.CarRepository;
import com.car.cleaning.pojo.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by jiangyunfan on 2018/12/18.
 */
@Component
@Slf4j
public class CarManager {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ValidationGateWay validationGateWay;

    public Car createOrUpdateCar(Car car) {

        validationGateWay.validateCar(car, ValidationPhase.CREATE_GUEST_CAR);
        /*根据传入是否有Car id，如果有，从数据库先查询是否有车的信息，没有，将作为一个零时洗车，赋予一个车辆ID号，通过此ID号，可以用一种通用URL从远程服务器上获取该辆车的图像信息。
          但是，最理想的情况，是外部设备能够提前获取车辆车牌信息。
         */
        Car inputCar = null;
        if (car.getCarId() != null) {
            //此处应该考虑网络超时原因，进行重试
            inputCar = carRepository.findById(car.getCarId()).get();
        }
        if (inputCar == null) {
            inputCar = new Car();
            //如果车辆信息无法从数据库中查询，将进行guest Car的信息重建
            //1. 将传进来的主要car信息进行初步拷贝
            inputCar.setCarBrand(car.getCarBrand());
            inputCar.setCarAge(car.getCarAge());
            inputCar.setCarIndicator(car.getCarIndicator());
            inputCar.setCarModel(car.getCarModel());
            inputCar.setExternalColor(car.getExternalColor());
            inputCar.setInternalColor(car.getInternalColor());
            inputCar.setSize(car.getSize());
            inputCar.setUserId(car.getUserId());
            return carRepository.save(inputCar);
        } else {
            return inputCar;
        }

    }

    public Car createCarOnFly(String carIndicator, Long userId) {
        Car existCar = carRepository.findCarByCarIndicator(carIndicator);
        if(existCar != null){
            return existCar;
        } else {
            Car car = new Car();
            car.setUserId(userId);
            car.setCarIndicator(carIndicator);
            return carRepository.save(car);
        }
    }


    public List<Car> findCarsByUserId(Long userId) {
        return carRepository.findCarsByUserId(userId);
    }
}
