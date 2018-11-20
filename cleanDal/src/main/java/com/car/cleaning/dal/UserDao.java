package com.car.cleaning.dal;


import com.car.cleaning.dalinterface.UserRepository;
import com.car.cleaning.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by jiangyunfan on 2018/11/20.
 */
@Component
public class UserDao {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.get();

    }

}
