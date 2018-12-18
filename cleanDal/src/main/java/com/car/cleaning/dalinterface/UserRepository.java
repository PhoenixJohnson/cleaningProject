package com.car.cleaning.dalinterface;

import com.car.cleaning.pojo.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jiangyunfan on 2018/11/20.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    @Transactional
    public void deleteByUserName(String userName);

    @Query(value = "SELECT o FROM User o ORDER BY o.userId")
    Page<User> findAllUsersWithPagination(Pageable pageable);

}
