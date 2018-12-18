package com.car.cleaning.dalinterface;

import com.car.cleaning.pojo.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jiangyunfan on 2018/11/20.
 */
public interface StoreRepository extends CrudRepository<Store, Long> {

    @Query(value = "SELECT o FROM Store o ORDER BY o.storeId")
    Page<Store> findAllStoresWithPagination(Pageable pageable);

}
