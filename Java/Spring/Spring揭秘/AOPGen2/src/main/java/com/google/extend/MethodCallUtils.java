package com.google.extend;

import org.springframework.aop.framework.AopContext;

public class MethodCallUtils {
    public MethodCallMethod getProxy() {
        return (MethodCallMethod) AopContext.currentProxy();
    }
}
