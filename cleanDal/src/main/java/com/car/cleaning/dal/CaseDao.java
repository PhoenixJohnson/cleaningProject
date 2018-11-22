package com.car.cleaning.dal;


import com.car.cleaning.dalinterface.CaseRepository;
import com.car.cleaning.pojo.Case;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by jiangyunfan on 2018/11/20.
 */
@Component
public class CaseDao {

    @Autowired
    private CaseRepository caseRepository;

    public Case findCaseById(Long caseId) {
        Optional<Case> caze = caseRepository.findById(caseId);
        return caze.get();

    }

}
