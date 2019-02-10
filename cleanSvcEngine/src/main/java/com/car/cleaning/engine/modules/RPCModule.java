package com.car.cleaning.engine.modules;


import com.car.cleaning.engine.domain.ModuleType;

public abstract class RPCModule<REQUEST, INVOKER> extends BaseModule {

    protected final INVOKER engineInvoker;

    protected RPCModule(String moduleHandlerName, String moduleHandlerId, INVOKER invoker) {
        super(ModuleType.CONNECTOR, moduleHandlerName, moduleHandlerId);
        this.engineInvoker = invoker;
    }

    abstract protected void validateRequest(REQUEST request);

}
