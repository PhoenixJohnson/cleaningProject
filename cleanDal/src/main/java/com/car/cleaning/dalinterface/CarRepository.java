package com.car.cleaning.dalinterface;

import com.car.cleaning.pojo.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by jiangyunfan on 2018/11/20.
 */
public interface CarRepository extends CrudRepository<Car, Long> {

    List<Car> findCarsByUserId(Long userId);

    List<Car> findCarsByCarBrand(String carBrand);

    Car findCarByCarIndicator(String carIndicator);

    List<Car> findCarsByCreationDateBetween(Date dateFrom, Date dateTo);

    List<Car> findCarsByCarAgeLessThanEqual(int age);

    @Query(value = "SELECT o FROM Car o ORDER BY o.carId")
    Page<Car> findAllCarsWithPagination(Pageable pageable);


}
