package com.car.cleaning.engine.domain;

import com.car.cleaning.common.BaseObject;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@Setter
public class EngineContext {

    private BaseObject inputObj;
    private LinkedHashMap<String, EngineOutput> outputChain;
    private Map<String, Object> context;
    private Object responseEntity;
    private AuditClientInfo auditClientInfo;
    private String refId;

}
