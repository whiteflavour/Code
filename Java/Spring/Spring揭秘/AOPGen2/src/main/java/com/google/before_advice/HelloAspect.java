package com.google.before_advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class HelloAspect {
    // @Pointcut("execution(public void com.google.before_advice.MockTask.execute(String)) && args(message)")
    private void joinPoints(String message) {}

    // @Before(value = "joinPoints(message)", argNames = "joinPoint,message")
    public void sayHello(JoinPoint joinPoint, String message) {
        System.out.println("hello before method["
                + joinPoint.getSignature().getName()
                + "]...[" + message + "]");
    }
}
