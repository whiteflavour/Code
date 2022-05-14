package com.google.dynamic_proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class DebugMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        String methodName = method.getName();
        System.out.println("Before method: " + methodName);
        Object obj = methodProxy.invokeSuper(o, objects);
        System.out.println("After method: " + methodName);
        return obj;
    }
}
