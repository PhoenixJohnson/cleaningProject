package com.car.cleaning.dal;


import com.car.cleaning.dalinterface.StoreRepository;
import com.car.cleaning.pojo.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by jiangyunfan on 2018/11/20.
 */
@Component
public class StoreDao {

    @Autowired
    private StoreRepository repository;

    public Store findStoreById(Long storeId) {
        Optional<Store> store = repository.findById(storeId);
        return store.get();

    }

}
