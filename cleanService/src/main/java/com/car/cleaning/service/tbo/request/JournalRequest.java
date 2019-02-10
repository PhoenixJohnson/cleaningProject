package com.car.cleaning.service.tbo.request;


import com.car.cleaning.common.BaseObject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Setter
@Getter
@ToString
public class JournalRequest implements BaseObject {

    private Boolean toAudit;
    private String journalToken;
    private String clientUniqueId;
    private String clientRefId;
    private String transactionId;
    private String sourceSystem;
    private String externalTrxId1;
    private String externalTrxId2;
    /**
     * REFUND/PAY/PAYOUT
     */
    private String trxType;
    private Date trxDate;
    private List<BalancePair> balancePairs;
    private Map<String, String> attributeMap;
}
