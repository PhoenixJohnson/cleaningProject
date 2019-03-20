package com.car.cleaning.core.manager;

import com.car.cleaning.bo.StoreBo;
import com.car.cleaning.core.manager.builder.CommonConstant;
import com.car.cleaning.core.validation.ValidationGateWay;
import com.car.cleaning.core.validation.ValidationPhase;
import com.car.cleaning.dalinterface.StoreRepository;
import com.car.cleaning.pojo.CashProtocol;
import com.car.cleaning.pojo.Facility;
import com.car.cleaning.pojo.Store;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by jiangyunfan on 2018/12/18.
 */
@Component
@Slf4j
public class StoreManager {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private FacilityManager facilityManager;

    @Autowired
    private CashProtManager cashProtManager;

    @Autowired
    private ValidationGateWay validationGateWay;

    public Store findOrUpdateStore(Store store) {

        validationGateWay.validateStore(store, ValidationPhase.CREATE_STORE);
        Store existStore = null;
        try {
            if (store.getStoreId() != null) {
                existStore = storeRepository.findById(store.getStoreId()).orElse(null);
                return existStore;
            }
        } catch (Exception e) {

        }
        Store newStore = new Store();
        if(store.getCashProtocolId() != null) {
            CashProtocol cashProtocol = cashProtManager.findByProtocolId(store.getCashProtocolId());
            if(cashProtocol!=null) {
                newStore.setActive(1);
            } else {
                newStore.setActive(0);
            }
        } else {
            newStore.setActive(0);
        }
        newStore.setAuthAmount(store.getAuthAmount() > 0 ? store.getAuthAmount() : CommonConstant.STORE_DEFAULT_AUTH_MONEY);
        newStore.setLevel(store.getLevel() > 0 ? store.getLevel() : CommonConstant.STORE_DEFAULT_LEVEL);
        newStore.setRunPeriod(store.getRunPeriod());
        newStore.setStoreAddress(store.getStoreAddress());
        newStore.setStoreOwnerName(store.getStoreOwnerName());
        newStore.setStoreOwnerPhone(store.getStoreOwnerPhone());
        newStore.setStorePaymentAccount(store.getStorePaymentAccount());
        return storeRepository.save(newStore);


    }

    public StoreBo findStoreBoById(Long storeId) {

        StoreBo storeBo = new StoreBo();
        //TODO Not null if null, throw exception
        Store store = storeRepository.findById(storeId).orElse(null);
        if(store.getCashProtocolId() != null && store.getCashProtocolId() >0) {
            storeBo.setCashProtocol(cashProtManager.findByProtocolId(store.getCashProtocolId()));
        }
        //Could be empty list
        List<Facility> facilities = facilityManager.findFacilitiesByStoreId(storeId);
        storeBo.setStore(store);
        storeBo.setFacilities(facilities);
        return storeBo;

    }

    public void deleteStoreById(Long storeId) {
        storeRepository.deleteById(storeId);
    }


    public Store findStoreById(Long storeId) {
        return storeRepository.findById(storeId).orElse(null);
    }
}
