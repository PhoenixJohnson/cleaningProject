package com.car.cleaning.dalinterface;

import com.car.cleaning.pojo.Flow;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by jiangyunfan on 2018/11/20.
 */
public interface FlowRepository extends CrudRepository<Flow, Long> {

    List<Flow> findFlowsByPayId(Long payId);

    @Query(value = "SELECT o FROM Flow o ORDER BY o.flowId")
    Page<Flow> findAllFlowsWithPagination(Pageable pageable);

}
