package com.google.ordered;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;

@Aspect("perthis(execution(public void *.execute(..)))")
public class MultiAdvicesAspect implements Ordered {
    @Pointcut("execution(public void *.execute(..))")
    public void taskExecution() {}

    @Before("taskExecution()")
    public void beforeOne() {
        System.out.println("before One");
    }

    @Before("taskExecution()")
    public void beforeTwo() {
        System.out.println("before Two");
    }

    @AfterReturning("taskExecution()")
    public void afterReturningOne() {
        System.out.println("after returning one");
    }

    @AfterReturning("taskExecution()")
    public void afterReturningTwo() {
        System.out.println("after returning two");
    }

    @Override
    public int getOrder() {
        return 20;
    }
}
