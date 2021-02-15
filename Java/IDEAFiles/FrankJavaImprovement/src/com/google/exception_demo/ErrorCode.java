package com.google.exception_demo;

public interface ErrorCode {
    /**
     *
     * @return 错误码
     */
    String getCode();

    /**
     *
     * @return 错误信息
     */
    String getMsg();
}
