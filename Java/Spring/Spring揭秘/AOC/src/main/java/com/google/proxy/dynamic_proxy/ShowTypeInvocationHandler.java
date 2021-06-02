package com.google.proxy.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ShowTypeInvocationHandler implements InvocationHandler {
    private Object target;

    public ShowTypeInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("showType")) {
            return method.invoke(target, args);
        }
        return null;
    }
}
