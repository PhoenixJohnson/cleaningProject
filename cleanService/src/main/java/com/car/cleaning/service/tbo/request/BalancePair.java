package com.car.cleaning.service.tbo.request;

import com.car.cleaning.common.BaseObject;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BalancePair implements BaseObject {

    private FinancialRef sourceRef;
    private FinancialRef destinationRef;

}
