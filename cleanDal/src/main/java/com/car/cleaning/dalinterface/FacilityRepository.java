package com.car.cleaning.dalinterface;

import com.car.cleaning.pojo.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jiangyunfan on 2018/11/20.
 */
public interface FacilityRepository extends CrudRepository<Facility, Long> {


    @Query(value = "SELECT o FROM Facility o ORDER BY o.facilityId")
    Page<Facility> findAllFacilitiesWithPagination(Pageable pageable);

}
