package com.car.cleaning.core.manager;

import com.car.cleaning.core.validation.ValidationGateWay;
import com.car.cleaning.core.validation.ValidationPhase;
import com.car.cleaning.dalinterface.CashProtocolRepository;
import com.car.cleaning.pojo.CashProtocol;
import com.car.cleaning.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by jiangyunfan on 2018/12/18.
 */
@Component
@Slf4j
public class CashProtManager {

    @Autowired
    private CashProtocolRepository cashProtocolRepository;

    @Autowired
    private ValidationGateWay validationGateWay;

    public CashProtocol createOrUpdateCashProtocol(CashProtocol cashProtocol) {
        validationGateWay.validateCashProtocol(cashProtocol, ValidationPhase.CREATE_CASH_PROTOCOL);
        return cashProtocolRepository.save(cashProtocol);
    }

    public CashProtocol findByProtocolId(Long protocolId) {
        return cashProtocolRepository.findById(protocolId).orElse(null);
    }

    /**
     * 一个店铺同时只能有一个合法的分红策略
     * 过期日期不包含过期当天
     * @param storeId
     * @return
     */
    public CashProtocol findByStoreId(Long storeId) {
        List<CashProtocol> protocolList = cashProtocolRepository.findByStoreId(storeId);
        for(CashProtocol cashProtocol: protocolList) {
            Date expireDate = DateUtil.getDateFromString(cashProtocol.getProtocolEndDate(), DateUtil.shortDateFormat);
            Date today = new Date();
            if(expireDate != null && expireDate.compareTo(today) <= 0) {
                return cashProtocol;
            }
        }
        return null;
    }

}
