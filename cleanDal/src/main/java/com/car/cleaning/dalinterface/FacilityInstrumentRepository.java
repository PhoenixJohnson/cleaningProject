package com.car.cleaning.dalinterface;

import com.car.cleaning.pojo.FacilityInstrument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jiangyunfan on 2018/11/20.
 */
public interface FacilityInstrumentRepository extends CrudRepository<FacilityInstrument, Long> {

    @Query(value = "SELECT o FROM FacilityInstrument o ORDER BY o.facilityInstrumentId")
    Page<FacilityInstrument> findAllCashPaysWithPagination(Pageable pageable);

}
