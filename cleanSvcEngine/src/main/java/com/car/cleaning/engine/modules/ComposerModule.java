package com.car.cleaning.engine.modules;


import com.car.cleaning.engine.domain.EngineContext;
import com.car.cleaning.engine.domain.ModuleType;
import com.car.cleaning.engine.exception.CCSvcModuleException;

public abstract class ComposerModule<OUTPUT_OBJ> extends BaseModule {

    protected ComposerModule(String moduleHandlerName, String moduleHandlerId) {
        super(ModuleType.BUSINESS, moduleHandlerName, moduleHandlerId);
    }

    abstract protected void buildBasicInfo(EngineContext engineContext, OUTPUT_OBJ outputRequest) throws CCSvcModuleException;

    abstract protected void buildCoreInfo(EngineContext engineContext, OUTPUT_OBJ outputRequest) throws CCSvcModuleException;


}
