package com.car.cleaning.bo;

import com.car.cleaning.pojo.Facility;
import com.car.cleaning.pojo.Store;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by jiangyunfan on 2018/12/18.
 */
@Setter
@Getter
public class StoreBo {

    private Store store;
    private List<Facility> facilities;

}
