package com.google.extend;

public class MethodCallMethod {
    private MethodCallUtils methodCallUtils;

    public MethodCallUtils getMethodCallUtils() {
        return methodCallUtils;
    }

    public void setMethodCallUtils(MethodCallUtils methodCallUtils) {
        this.methodCallUtils = methodCallUtils;
    }

    public void method1() {
        System.out.println("method1...");
    }

    public void method2() {
        methodCallUtils.getProxy().method1();
        System.out.println("method2...");
    }
}
