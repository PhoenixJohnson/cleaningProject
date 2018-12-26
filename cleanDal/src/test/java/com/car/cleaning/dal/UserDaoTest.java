package com.car.cleaning.dal;


import com.car.cleaning.dalinterface.UserRepository;
import com.car.cleaning.pojo.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by jiangyunfan on 2018/11/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:dalBeanConfig.xml")
public class UserDaoTest {

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
//        userRepository.deleteByUserName("slink");

    }

    @Test
    public void createUser() throws Exception {

        User user = new User();
        user.setPhone("1121212");
        user.setAge(35);
        user.setEmailAddress("cc@login.com");
        user.setPassword("121212");
        user.setActive(1);
        user.setGuest(false);
        user.setUserName("slink");
        user.setUserPaymentAccount("cc@alipay.com");
        user.setCreationDate(new Date());
        user.setLastModifiedDate(new Date());

        User userReturn = userRepository.save(user);
        System.out.println(userReturn.toString());

    }


}