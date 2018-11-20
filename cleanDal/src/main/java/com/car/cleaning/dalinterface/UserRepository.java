package com.car.cleaning.dalinterface;

import com.car.cleaning.pojo.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jiangyunfan on 2018/11/20.
 */
public interface UserRepository extends CrudRepository<User, Long> {

}
