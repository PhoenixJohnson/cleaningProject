package com.car.cleaning.dalinterface;

import com.car.cleaning.pojo.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by jiangyunfan on 2018/11/20.
 */
public interface PaymentRepository extends CrudRepository<Payment, Long> {

    List<Payment> findPaymentsByUserId(Long userId);

    List<Payment> findPaymentsByCarId(Long carId);

    List<Payment> findPaymentsByStoreId(Long storeId);

    List<Payment> findPaymentsByUserPaymentAccount(String userPaymentAccount);

    List<Payment> findPaymentsByStorePaymentAccount(String storePaymentAccount);

    int countAllByPaymentMethod(String paymentMethod);

    @Query(value = "SELECT o FROM Payment o ORDER BY o.payId")
    Page<Payment> findAllPaymentsWithPagination(Pageable pageable);

}
