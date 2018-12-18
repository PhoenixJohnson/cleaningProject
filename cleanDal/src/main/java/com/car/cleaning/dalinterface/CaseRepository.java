package com.car.cleaning.dalinterface;

import com.car.cleaning.pojo.Case;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jiangyunfan on 2018/11/20.
 */
public interface CaseRepository extends CrudRepository<Case, Long> {

    @Query(value = "SELECT o FROM Case o ORDER BY o.caseId")
    Page<Case> findAllCasesWithPagination(Pageable pageable);

}
