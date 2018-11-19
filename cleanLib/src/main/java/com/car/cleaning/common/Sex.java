package com.car.cleaning.common;

import lombok.Getter;

/**
 * Created by jiangyunfan on 2018/11/19.
 */
public enum Sex {

    MALE(1),FEMALE(2);

    @Getter
    private int sexCode;

    private Sex(int code) {
        this.sexCode = code;
    }
}
