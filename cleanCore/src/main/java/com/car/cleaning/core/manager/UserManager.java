package com.car.cleaning.core.manager;

import com.car.cleaning.bo.UserBo;
import com.car.cleaning.dalinterface.UserRepository;
import com.car.cleaning.pojo.Car;
import com.car.cleaning.pojo.User;
import com.car.cleaning.util.UUIDGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


/**
 * Created by jiangyunfan on 2018/12/18.
 */
@Component
@Slf4j
public class UserManager {


    private static final String DEFAULT_PASSWORD = "12345678";
    private static final String DEFAULT_PHONE_NUMBER = "12345678";
    private static final String DEFAULT_EMAIL = "guest@CClean.com";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CarManager carManager;

    public UserBo createGuestUserBo(Car car, String paymentAccount) {

        UserBo userBo = new UserBo();
        User guestUser = new User();
        guestUser.setGuest(true);
        guestUser.setActive(1);
        guestUser.setUserPaymentAccount(paymentAccount);
        guestUser.setUserName(UUIDGenerator.getUUID());
        guestUser.setPassword(DEFAULT_PASSWORD);
        guestUser.setPhone(DEFAULT_PHONE_NUMBER);
        guestUser.setEmailAddress(DEFAULT_EMAIL);
        //TODO 如果保存用户失败，是否抛出异常
        userBo.setUser(userRepository.save(guestUser));
        //Guest用户只有一辆车，如果保存车辆信息失败，可以容忍错误。
        Car carInfo = carManager.createCar(car);
        userBo.setCars(Arrays.asList(carInfo));
        userBo.setCurrentCar(carInfo);
        return userBo;
    }

    public UserBo findOrCreateUser(User user, Car car, String paymentAccount) {
        User existUser = null;
        if(user.getUserId() != null) {
            existUser = userRepository.findById(user.getUserId()).get();
        }
        if(existUser == null) {
            //如果用户不存在
            return createGuestUserBo(car, paymentAccount);
        }
        //如果用户存在，需要找到所有相关信息，然后再返回
        Car currentCar = carManager.createCar(car);
        List<Car> carList = carManager.findCarsByUserId(existUser.getUserId());
        if(!carList.contains(currentCar)) {
            carList.add(currentCar);
        }
        return new UserBo(existUser, currentCar, carList);

    }

}