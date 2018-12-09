package com.car.cleaning.engine.modules;

import com.car.cleaning.engine.exception.SvcEngineException;

import java.util.List;

public interface BaseModuleBuilder {
    public List<BaseModule> buildModules() throws SvcEngineException;
}
