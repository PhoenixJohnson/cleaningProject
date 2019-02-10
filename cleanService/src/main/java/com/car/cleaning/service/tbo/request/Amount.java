package com.car.cleaning.service.tbo.request;

import com.car.cleaning.common.BaseObject;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Amount implements BaseObject {

    private Double value;
    private String currency;
}
