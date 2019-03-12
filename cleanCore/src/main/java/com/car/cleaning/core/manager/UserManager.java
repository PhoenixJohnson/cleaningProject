package com.car.cleaning.core.manager;

import com.car.cleaning.bo.UserBo;
import com.car.cleaning.core.manager.builder.CommonConstant;
import com.car.cleaning.core.validation.ValidationGateWay;
import com.car.cleaning.core.validation.ValidationPhase;
import com.car.cleaning.dalinterface.UserRepository;
import com.car.cleaning.pojo.Car;
import com.car.cleaning.pojo.User;
import com.car.cleaning.util.UUIDGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by jiangyunfan on 2018/12/18.
 */
@Component
@Slf4j
public class UserManager {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CarManager carManager;

    @Autowired
    private ValidationGateWay validationGateWay;

    public UserBo createGuestUserBo(Car car, String paymentAccount) {

        UserBo userBo = new UserBo();
        User guestUser = new User();
        guestUser.setGuest(true);
        guestUser.setActive(1);
        guestUser.setUserPaymentAccount(paymentAccount);
        guestUser.setUserName(UUIDGenerator.getUUID());
        guestUser.setPassword(CommonConstant.DEFAULT_PASSWORD);
        guestUser.setPhone(CommonConstant.DEFAULT_PHONE_NUMBER);
        guestUser.setEmailAddress(CommonConstant.DEFAULT_EMAIL);
        //TODO 如果保存用户失败，是否抛出异常
        userBo.setUser(userRepository.save(guestUser));
        //Guest用户只有一辆车，如果保存车辆信息失败，可以容忍错误。
        Car carInfo = carManager.findOrUpdateCar(car);
        userBo.setCars(Arrays.asList(carInfo));
        userBo.setCurrentCar(carInfo);
        return userBo;
    }

    public User createGuestUserOnFly(String paymentAccount) {

        User guestUser = new User();
        guestUser.setGuest(true);
        guestUser.setActive(1);
        guestUser.setUserPaymentAccount(paymentAccount);
        guestUser.setUserName(UUIDGenerator.getUUID());
        guestUser.setPassword(CommonConstant.DEFAULT_PASSWORD);
        guestUser.setPhone(CommonConstant.DEFAULT_PHONE_NUMBER);
        guestUser.setEmailAddress(CommonConstant.DEFAULT_EMAIL);
        return userRepository.save(guestUser);
    }

    public User findUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public UserBo findOrCreateUserBo(User user, Car car, String paymentAccount) {
        User existUser = null;
        if(user.getUserId() != null) {
            existUser = userRepository.findById(user.getUserId()).orElse(null);
        }
        if(existUser == null) {
            //如果用户不存在
            return createGuestUserBo(car, paymentAccount);
        }
        //如果用户存在，需要找到所有相关信息，然后再返回
        Car currentCar = carManager.findOrUpdateCar(car);
        List<Car> carList = new ArrayList<>();
        if(!existUser.isGuest()) {
            carList = carManager.findCarsByUserId(existUser.getUserId());
            if (!carList.contains(currentCar)) {
                carList.add(currentCar);
            }
        }
        return new UserBo(existUser, currentCar, carList);

    }

    public User findOrCreateUser(User user) {

        validationGateWay.validateUser(user, ValidationPhase.CREATE_USER);
        try {
            if (user.getUserId() != null) {
                return userRepository.findById(user.getUserId()).orElse(null);
            }
        } catch (Exception e) {

        }
        User newUser = new User();
        newUser.setEmailAddress(user.getEmailAddress());
        newUser.setPhone(user.getPhone());
        newUser.setPassword(user.getPassword());
        newUser.setUserName(user.getUserName());
        newUser.setUserPaymentAccount(user.getUserPaymentAccount());
        newUser.setActive(user.getActive());
        newUser.setGuest(false);
        newUser.setAge(user.getAge());
        newUser.setExternalLoginIndicator(user.getExternalLoginIndicator());
        newUser.setSex(user.getSex());

        return userRepository.save(newUser);

    }

}
