package com.car.cleaning.engine.exception;

public class SvcEngineException extends Exception {

    private EngineErrorCode errorCode;

    public SvcEngineException(EngineErrorCode errorCode, Exception e) {
        super(e);
        this.errorCode = errorCode;
    }

    public SvcEngineException(EngineErrorCode errorCode, String error) {
        super(error);
        this.errorCode = errorCode;
    }

    public EngineErrorCode getErrorCode() {
        return errorCode;
    }

}
