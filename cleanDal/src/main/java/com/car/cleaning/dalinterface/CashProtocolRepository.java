package com.car.cleaning.dalinterface;

import com.car.cleaning.pojo.CashProtocol;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by jiangyunfan on 2018/11/20.
 */
public interface CashProtocolRepository extends CrudRepository<CashProtocol, Long> {

    @Query(value = "SELECT o FROM CashProtocol o ORDER BY o.cashProtocolId")
    Page<CashProtocol> findAllCashProtocolsWithPagination(Pageable pageable);

    List<CashProtocol> findByStoreId(Long storeId);

}
