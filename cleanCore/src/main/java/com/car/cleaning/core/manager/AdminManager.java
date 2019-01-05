package com.car.cleaning.core.manager;

import com.car.cleaning.core.validation.ValidationGateWay;
import com.car.cleaning.core.validation.ValidationPhase;
import com.car.cleaning.dalinterface.AdminRepository;
import com.car.cleaning.pojo.Admin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by jiangyunfan on 2018/12/18.
 */
@Component
@Slf4j
public class AdminManager {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ValidationGateWay validationGateWay;

    /**
     * 创建或者更新admin，此操作调用前，已经确定该admin必定已经存在，否则会抛错
     * @param admin
     * @return
     */
    public Admin createOrUpdateAdmin(Admin admin) {
        validationGateWay.validateAdmin(admin, ValidationPhase.CREATE_ADMIN);
        return adminRepository.save(admin);
    }



    public Admin findAdminInfoById(Long adminId) {
        return adminRepository.findById(adminId).get();
    }

    public String getRoleListByAdminId(Long adminId) {
        return adminRepository.findById(adminId).get().getRoleList();
    }
}
