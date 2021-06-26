package com.google.ordered;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.Ordered;

@Aspect
public class AnotherAspect implements Ordered {
    @Before("execution(public void *.execute())")
    public void doBefore() {
        System.out.println("before in AnotherAspect...");
    }

    @Override
    public int getOrder() {
        return 100;
    }
}
