package com.car.cleaning.dalinterface;

import com.car.cleaning.pojo.Admin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jiangyunfan on 2018/11/20.
 */
public interface AdminRepository extends CrudRepository<Admin, Long> {

    @Query(value = "SELECT o FROM Admin o ORDER BY o.adminId")
    Page<Admin> findAllAdminsWithPagination(Pageable pageable);

}
