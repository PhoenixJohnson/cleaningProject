package com.car.cleaning.exception;

public enum CleanErrorCode {


    VALIDATION_ERROR(false, "Validation error", 400000),
    CONFIG_ERROR(false, "Configuration error", 400001),
    PAYLOAD_ERROR(false, "Payload Error.", 400002),
    BIZ_VALIDATION_ERROR(false, "Validation error", 400003),
    DB_EXCEPTION(false, "Database finding error", 400004),
    SERVICE_REJECT_ERROR(false, "Server reject error", 400005),
    RPC_ERROR(true, "RPC call related error.", 500002);

    private final boolean needRetry;
    private final String description;
    private final int errorId;

    CleanErrorCode(boolean needRetry, String desc, int errorId) {
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
