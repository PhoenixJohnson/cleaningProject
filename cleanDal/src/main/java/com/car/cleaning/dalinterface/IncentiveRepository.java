package com.car.cleaning.dalinterface;

import com.car.cleaning.pojo.Incentive;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jiangyunfan on 2018/11/20.
 */
public interface IncentiveRepository extends CrudRepository<Incentive, Long> {

    @Query(value = "SELECT o FROM Incentive o ORDER BY o.incentiveId")
    Page<Incentive> findAllIncentivesWithPagination(Pageable pageable);

}
