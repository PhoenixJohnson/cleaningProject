package com.car.cleaning.rpc;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by jiangyunfan on 2018/11/22.
 */
@Setter
@Getter
public class CConsoleRequest {

    private String startDate;
    private String endDate;
    private String pageSize;
    private String pageNumber;

}
