package com.car.cleaning.dal;


import com.car.cleaning.dalinterface.CarRepository;
import com.car.cleaning.pagination.CarPagination;
import com.car.cleaning.pojo.Car;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.Random;

/**
 * Created by jiangyunfan on 2018/11/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:dalBeanConfig.xml")
public class CarDaoTest {

    @Autowired
    private CarRepository carRepository;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void createCars() throws Exception {

        for(int i=0;i<10;i++){
            Car car = new Car();
            car.setCarAge(2);
            car.setCarBrand("BMW");
            car.setCarIndicator(String.valueOf(new Random().nextDouble()));
            car.setCarModel("big");
            car.setExternalColor("black");
            car.setInternalColor("white");
            car.setUserId(Math.abs(new Random().nextLong()));
            car.setCreationDate(new Date());
            car.setLastModifiedDate(new Date());
            carRepository.save(car);
        }

    }

    @Test
    public void paginateCarList() throws Exception {
        CarPagination pageable = new CarPagination();
        Page<Car> cars = carRepository.findAllCarsWithPagination(pageable);
        for(Car car: cars.getContent()){
            System.out.println(car.toString());
        }
    }


}