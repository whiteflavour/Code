package com.google.around_advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AroundAspect {
    @Around(value = "execution(public void AroundClass.turnAround(String)) && args(message)")
    public Object around(ProceedingJoinPoint pjp, String message) throws Throwable {
        System.out.println("---------Aspect---------");
        System.out.println("in aspect, you have turned around...");
        String newMessage = "lover";
        return pjp.proceed(new Object[]{newMessage});
    }
}
