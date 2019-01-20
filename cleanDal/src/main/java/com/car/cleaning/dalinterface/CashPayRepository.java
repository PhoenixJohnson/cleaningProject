package com.car.cleaning.dalinterface;

import com.car.cleaning.pojo.CashPay;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jiangyunfan on 2018/11/20.
 */
public interface CashPayRepository extends CrudRepository<CashPay, Long> {

    @Query(value = "SELECT o FROM CashPay o ORDER BY o.cashPayId")
    Page<CashPay> findAllCashPaysWithPagination(Pageable pageable);

}
