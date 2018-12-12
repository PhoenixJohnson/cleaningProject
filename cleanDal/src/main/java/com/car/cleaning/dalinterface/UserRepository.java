package com.car.cleaning.dalinterface;

import com.car.cleaning.pojo.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jiangyunfan on 2018/11/20.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    @Transactional
    public void deleteByUserName(String userName);

}
