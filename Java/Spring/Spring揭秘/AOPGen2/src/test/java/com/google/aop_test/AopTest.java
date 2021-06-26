package com.google.aop_test;

import com.google.extend.MethodCallMethod;
import com.google.extend.SomeAspect;
import com.google.introduction.ICounter;
import com.google.after_advice.after_finally.FinallyClass;
import com.google.after_advice.after_returning.ReturningClass;
import com.google.after_advice.after_throwing.DivideZeroClass;
import com.google.around_advice.AroundClass;
import com.google.around_advice.Foo;
import com.google.before_advice.MockTask;
import com.google.around_advice.PerformanceTraceAspect;
import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class AopTest {
    @Test
    public void aopTest() {
        AspectJProxyFactory weaver = new AspectJProxyFactory();
        weaver.setProxyTargetClass(true);
        weaver.setTarget(new Foo());
        weaver.addAspect(PerformanceTraceAspect.class);
        Object proxy = weaver.getProxy();
        System.out.println(proxy);
        ((Foo)proxy).method1();
        ((Foo)proxy).method2();
    }

    @Test
    public void autoProxyTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Object proxy = context.getBean("target");
        System.out.println(proxy);
        ((Foo)proxy).method1();
        ((Foo)proxy).method2();
    }

    @Test
    public void beforeAdviceTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Object proxy = context.getBean("mockTask");
        ((MockTask)proxy).execute("-----------------------------------------------");
    }

    @Test
    public void afterThrowingTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Object proxy = context.getBean("divideZero");
        ((DivideZeroClass)proxy).operate();
    }

    @Test
    public void afterReturningTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Object proxy = context.getBean("returning");
        System.out.println(((ReturningClass) proxy).returning());
    }

    @Test
    public void afterFinallyTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Object proxy = context.getBean("shitClass");
        ((FinallyClass)proxy).finallyGotShit();
    }

    @Test
    public void aroundTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Object proxy = context.getBean("aroundClass");
        ((AroundClass)proxy).turnAround("fucker");
    }

    @Test
    public void introductionTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Object task1 = context.getBean("task");
        Object task2 = context.getBean("task");

        System.out.println(((ICounter)task1).getCount());
        System.out.println(((ICounter)task1).getCount());
        System.out.println(((ICounter)task2).getCount());
        ((com.google.introduction.MockTask)task1).execute();
        ((com.google.introduction.MockTask)task2).execute();
    }

    @Test
    public void orderTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Object mockTask = context.getBean("task");
        ((com.google.introduction.MockTask)mockTask).execute();
    }

    @Test
    public void testNestedMethodCall() {
        AspectJProxyFactory weaver = new AspectJProxyFactory(new MethodCallMethod());
        weaver.setProxyTargetClass(true);
        weaver.addAspect(SomeAspect.class);
        weaver.setExposeProxy(true);
        Object proxy = weaver.getProxy();
        ((MethodCallMethod)proxy).method1();
        ((MethodCallMethod)proxy).method2();
    }
}
