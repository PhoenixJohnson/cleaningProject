package com.car.cleaning.exception;

public class CleanException extends Exception {

    private CleanErrorCode errorCode;

    public CleanException(CleanErrorCode errorCode, Exception e) {
        super(e);
        this.errorCode = errorCode;
    }

    public CleanException(CleanErrorCode errorCode, String error) {
        super(error);
        this.errorCode = errorCode;
    }

    public CleanErrorCode getErrorCode() {
        return errorCode;
    }

}
