package com.google.extend;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class SomeAspect {
    @Around("execution(public void MethodCallMethod.method1()) || execution(public void MethodCallMethod.method2())")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("-----------------------------");
        System.out.println("around ...");
        return pjp.proceed();
    }
}
