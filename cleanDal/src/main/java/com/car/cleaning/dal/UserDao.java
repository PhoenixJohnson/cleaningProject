package com.car.cleaning.dal;


import com.car.cleaning.dalinterface.UserRepository;
import com.car.cleaning.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by jiangyunfan on 2018/11/20.
 */
@Service
public class UserDao {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.get();

    }

    @Transactional
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public void deleteUserByName(String userName) {
        userRepository.deleteByUserName(userName);
    }

}
