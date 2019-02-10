package com.car.cleaning.service.tbo.request;

import com.car.cleaning.common.BaseObject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FinancialRef implements BaseObject {

    private String id;
    private String accountType;
    private String refId;
    private Amount amount;
    private String memo;

}
