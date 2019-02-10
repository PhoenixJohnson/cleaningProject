package com.car.cleaning.engine.exception;

public class CCSvcEngineException extends Exception {

    private EngineErrorCode errorCode;

    public CCSvcEngineException(EngineErrorCode errorCode, Exception e) {
        super(e);
        this.errorCode = errorCode;
    }

    public CCSvcEngineException(EngineErrorCode errorCode, String error) {
        super(error);
        this.errorCode = errorCode;
    }

    public EngineErrorCode getErrorCode() {
        return errorCode;
    }

}
