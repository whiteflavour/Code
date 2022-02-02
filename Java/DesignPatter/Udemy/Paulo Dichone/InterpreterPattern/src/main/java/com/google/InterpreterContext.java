package com.google;

public class InterpreterContext {
    public String getBinaryFormat(int num) {
        return Integer.toBinaryString(num);
    }

    public String getHexFormat(int num) {
        return Integer.toHexString(num);
    }
}
