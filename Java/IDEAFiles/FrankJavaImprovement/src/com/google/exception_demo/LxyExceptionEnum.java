package com.google.exception_demo;

public enum LxyExceptionEnum implements ErrorCode {
    NOT_FOUND_PAGE("404", "Page not found!"),
    TOO_BIG_NUMBER("666", "数字太大！！")
    ;

    private final String code;
    private final String Msg;

    LxyExceptionEnum(String code, String Msg) {
        this.code = code;
        this.Msg = Msg;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return Msg;
    }
}
