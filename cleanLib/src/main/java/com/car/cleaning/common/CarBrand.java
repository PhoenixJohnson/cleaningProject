package com.car.cleaning.common;

import lombok.Getter;

/**
 * Created by jiangyunfan on 2018/11/20.
 */
public enum CarBrand {

    BMW("宝马"),
    Benz("奔驰");

    @Getter
    private String brandName;

    private CarBrand(String code) {
        this.brandName = code;
    }

}
