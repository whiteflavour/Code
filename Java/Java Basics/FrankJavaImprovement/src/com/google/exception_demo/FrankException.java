package com.google.exception_demo;

/**
 * Frank 定义的异常类，与我定义的不同。
 * @author Frank
 * @datetime 2020-9-21
 */
public class FrankException extends Exception {
    FrankException(ErrorCode errorCode) {
        super(errorCode.getMsg());
    }
}
