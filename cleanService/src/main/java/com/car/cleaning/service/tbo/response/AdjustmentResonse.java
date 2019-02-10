package com.car.cleaning.service.tbo.response;


import com.car.cleaning.common.BaseObject;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdjustmentResonse extends BaseResponse implements BaseObject {

    private Long journalId;
    private String paymentOpsTrackId;

}
