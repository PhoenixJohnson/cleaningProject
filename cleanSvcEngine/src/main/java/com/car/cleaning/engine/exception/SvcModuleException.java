package com.car.cleaning.engine.exception;

public class SvcModuleException extends Exception {

    private EngineErrorCode errorCode;

    public SvcModuleException(EngineErrorCode errorCode, Exception e) {
        super(e);
        this.errorCode = errorCode;
    }

    public SvcModuleException(EngineErrorCode errorCode, String error) {
        super(error);
        this.errorCode = errorCode;
    }

    public EngineErrorCode getErrorCode() {
        return errorCode;
    }

}
