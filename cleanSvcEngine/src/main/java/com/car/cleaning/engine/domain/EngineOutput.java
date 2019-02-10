package com.car.cleaning.engine.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EngineOutput {

    private ModuleType moduleType;
    private String moduleHandlerName;
    private String moduleHandlerId;
    private String moduleUUID;
    private ContextStepName currentStep;
    private Object outputObj;
    private boolean isError;
    private String logMessage;

}
