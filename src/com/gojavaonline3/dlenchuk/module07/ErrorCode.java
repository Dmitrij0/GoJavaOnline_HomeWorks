package com.gojavaonline3.dlenchuk.module07;

public enum ErrorCode {
    INTERNAL_ERROR(1000),
    INCORRECT_PARAM(1002),
    NOT_ENOUGH_MONEY(1003),
    PRODUCT_NOT_FOUND(1004),
    UNREGISTERED_CURRENCY(1005);

    private final int code;

    ErrorCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static ErrorCode fromValue(String v) {
        return valueOf(v);
    }
}