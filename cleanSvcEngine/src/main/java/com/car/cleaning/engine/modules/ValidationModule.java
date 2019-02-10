package com.car.cleaning.engine.modules;


import com.car.cleaning.engine.domain.ModuleType;

public abstract class ValidationModule<INPUT_OBJ> extends BaseModule {

    protected ValidationModule(String moduleHandlerName, String moduleHandlerId) {
        super(ModuleType.VALIDATOR, moduleHandlerName, moduleHandlerId);
    }

}
