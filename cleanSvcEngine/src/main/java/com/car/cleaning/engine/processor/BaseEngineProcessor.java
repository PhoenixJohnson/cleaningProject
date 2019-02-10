package com.car.cleaning.engine.processor;


import com.car.cleaning.common.BaseObject;
import com.car.cleaning.engine.audit.EngineAudit;
import com.car.cleaning.engine.domain.ContextKeyName;
import com.car.cleaning.engine.domain.EngineContext;
import com.car.cleaning.engine.domain.EngineOutput;
import com.car.cleaning.engine.exception.CCSvcEngineException;
import com.car.cleaning.engine.modules.BaseModule;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@Slf4j
public abstract class BaseEngineProcessor<INPUT_BO extends BaseObject> {

    private final static Gson gson = new Gson();
    
    @Autowired
    private EngineAudit engineAudit;

    private boolean filterModule(BaseModule module) {

        return false;
    }

    private EngineContext moduleProcessing(List<BaseModule> modules, EngineContext engineContext) throws CCSvcEngineException {

        for (BaseModule module : modules) {
            if (!filterModule(module)) {
                module.handle(engineContext);
            }
        }
        return engineContext;

    }

    private void preLogAudit(EngineContext engineContext, INPUT_BO inputBo) {

        log.info(String.format("Engine processing class: %s, with content: %s.", inputBo.getClass(), gson.toJson(inputBo)));
        

    }

    private void afterLogAudit(EngineContext engineContext) {

        log.info(String.format("Engine unit content after processing: %s.", gson.toJson(engineContext)));

    }

    private void init(EngineContext engineContext, INPUT_BO inputBo) {

        engineContext.setContext(new HashMap<String, Object>());
        engineContext.setOutputChain(new LinkedHashMap<String, EngineOutput>(100, 1.0f, true));
        engineContext.setInputObj(inputBo);
    }

    public EngineContext process(List<BaseModule> inputModuleList, EngineContext engineContext, INPUT_BO inputBo) {

        try {

            init(engineContext, inputBo);

            preLogAudit(engineContext,inputBo);

            EngineContext output = moduleProcessing(inputModuleList, engineContext);

            afterLogAudit(engineContext);

            return output;

        } catch (CCSvcEngineException fsexception) {//4000X, //5000x
            engineContext.getContext().put(ContextKeyName.ERROR_CODE.name(), fsexception.getErrorCode().getErrorId());
            engineContext.getContext().put(ContextKeyName.ERROR_SHORT_MSG.name(), fsexception.getErrorCode().getDescription());
            engineContext.getContext().put(ContextKeyName.ERROR_LONG_MSG.name(), fsexception.getMessage());
            log.error("Engine processing  failed", fsexception.getMessage());
    		
            return engineContext;
        } catch (Exception e) {
            engineContext.getContext().put(ContextKeyName.ERROR_LONG_MSG.name(), e.getMessage());
            log.error("Engine processing  failed", e.getMessage());
            return engineContext;
        }


    }

}
