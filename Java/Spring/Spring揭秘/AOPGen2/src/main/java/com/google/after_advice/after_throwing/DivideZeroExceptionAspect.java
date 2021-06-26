package com.google.after_advice.after_throwing;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class DivideZeroExceptionAspect {
    @AfterThrowing(pointcut = "execution(public void com.google.after_advice.after_throwing.DivideZeroClass.operate())", throwing = "e")
    public void afterThrowing(RuntimeException e) {
        System.out.println("Exception[" + e.getClass().getName() + "]...");
    }
}
