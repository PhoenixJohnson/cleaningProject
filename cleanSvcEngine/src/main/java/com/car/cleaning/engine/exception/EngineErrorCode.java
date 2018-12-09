package com.car.cleaning.engine.exception;

public enum EngineErrorCode {


    VALIDATION_ERROR(false, "Validation error", 400000),
    CONFIG_ERROR(false, "Configuration error", 400001),
    PAYLOAD_ERROR(false, "Payload Error.", 400002),
    MODULE_HANDLING_ERROR(false, "Module handling error", 400003),
    BIZ_VALIDATION_ERROR(false, "Validation error", 400004),
    DB_EXCEPTION(false, "Database finding error", 400005),
    SERVICE_REJECT_ERROR(false, "Server reject error", 400006),
    RPC_ERROR(true, "RPC call related error.", 500002);

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
