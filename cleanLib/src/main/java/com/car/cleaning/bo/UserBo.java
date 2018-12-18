package com.car.cleaning.bo;

import com.car.cleaning.pojo.Car;
import com.car.cleaning.pojo.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by jiangyunfan on 2018/12/18.
 */
@Setter
@Getter
public class UserBo {

    private User user;
    private List<Car> cars;
}
