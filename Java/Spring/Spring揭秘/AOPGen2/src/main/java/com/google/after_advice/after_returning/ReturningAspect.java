package com.google.after_advice.after_returning;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class ReturningAspect {
    @AfterReturning(pointcut = "execution(public int ReturningClass.returning())", returning = "result")
    public void afterReturning(int result) {
        System.out.println("--------Aspect---------");
        System.out.println("in Aspect, returning: " + result);
    }
}
