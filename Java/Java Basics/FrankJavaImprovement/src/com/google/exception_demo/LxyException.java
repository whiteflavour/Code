package com.google.exception_demo;

/**
 * 自定义异常类
 * @author Lxy
 * @datetime 2020-9-19
 */
public class LxyException extends Exception {
//    private String code;
//    private String Msg;

    public LxyException() {}
    public LxyException(Enum<LxyExceptionEnum> Msg) {}

//    @Override
//    public String getCode() {
//        return code;
//    }
//
//    @Override
//    public String getMsg() {
//        return Msg;
//    }

    @Override
    public String toString() {
        return super.toString();
    }
}
