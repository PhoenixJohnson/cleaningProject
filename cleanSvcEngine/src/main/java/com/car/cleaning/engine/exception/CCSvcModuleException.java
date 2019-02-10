package com.car.cleaning.engine.exception;

public class CCSvcModuleException extends Exception {

    private EngineErrorCode errorCode;

    public CCSvcModuleException(EngineErrorCode errorCode, Exception e) {
        super(e);
        this.errorCode = errorCode;
    }

    public CCSvcModuleException(EngineErrorCode errorCode, String error) {
        super(error);
        this.errorCode = errorCode;
    }

    public EngineErrorCode getErrorCode() {
        return errorCode;
    }

}
