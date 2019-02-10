package com.car.cleaning.engine.modules;

import com.car.cleaning.engine.domain.EngineContext;
import com.car.cleaning.engine.domain.EngineOutput;
import com.car.cleaning.engine.domain.ModuleType;
import com.car.cleaning.engine.exception.CCSvcEngineException;
import com.car.cleaning.engine.util.UUIDGenerator;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;


@Getter
@Scope(value = "prototype")
public abstract class BaseModule {

    final protected ModuleType moduleType;

    final public String moduleHandlerName;

    final public String moduleHandlerId;

    final public String moduleUUID = UUIDGenerator.getUUID();

    @Setter
    private String currentStep;

    @Setter
    private String previousStep;

    @Setter
    private String nextStep;

    protected BaseModule(ModuleType moduleType, String moduleHandlerName, String moduleHandlerId) {
        this.moduleHandlerName = moduleHandlerName;
        this.moduleType = moduleType;
        this.moduleHandlerId = moduleHandlerId;
    }

    public abstract EngineOutput handle(EngineContext engineContext) throws CCSvcEngineException;



}
