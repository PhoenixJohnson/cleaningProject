package com.car.cleaning.engine.exception;

public enum EngineErrorCode {


    VALIDATION_ERROR(false, "Validation error", 400100),
    CONFIG_ERROR(false, "Configuration error", 400200),
    PAYLOAD_ERROR(false, "Payload Error", 400300),
    MODULE_HANDLING_ERROR(false, "Module handling error", 400400),
    BIZ_VALIDATION_ERROR(false, "Module Biz Validation error", 400500),
    DB_EXCEPTION(false, "Database finding error", 400600),
    SERVICE_REJECT_ERROR(false, "Server reject error", 400700),
    GINGER_ERROR(true, "API related error", 500100);

    private final boolean needRetry;
    private final String description;
    private final int errorId;

    EngineErrorCode(boolean needRetry, String desc, int errorId) {
        this.needRetry = needRetry;
        this.description = desc;
        this.errorId = errorId;
    }


    public int getErrorId() {
        return errorId;
    }

    public boolean isNeedRetry() {
        return needRetry;
    }

    public String getDescription() {
        return description;
    }


}
