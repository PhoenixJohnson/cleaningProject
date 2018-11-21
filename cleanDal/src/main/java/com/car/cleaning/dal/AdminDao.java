package com.car.cleaning.dal;


import com.car.cleaning.dalinterface.AdminRepository;
import com.car.cleaning.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by jiangyunfan on 2018/11/20.
 */
@Component
public class AdminDao {

    @Autowired
    private AdminRepository repository;

    public Admin findAdminUserById(Long adminUserId) {
        Optional<Admin> user = repository.findById(adminUserId);
        return user.get();

    }

}
