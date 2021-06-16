package com.google.weaver_test;

import com.google.advice.Developer;
import com.google.advice.IDeveloper;
import com.google.advice.ITester;
import com.google.aspect.TesterFeatureIntroductionInterceptor;
import com.google.weaving.class_based.Executable;
import com.google.weaving.interface_based.ITask;
import com.google.weaving.interface_based.MockTask;
import com.google.weaving.interface_based.PerformanceMethodInterceptor;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

public class WeaverTest {
    @Test
    public void interfaceBasedProxyTest() {
        MockTask task = new MockTask();
        ProxyFactory weaver = new ProxyFactory(task);
        weaver.setInterfaces(ITask.class);
        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();
        advisor.setMappedName("execute");
        advisor.setAdvice(new PerformanceMethodInterceptor());
        weaver.addAdvisor(advisor);
        ITask proxyObject = (ITask) weaver.getProxy();
        proxyObject.execute();
    }

    @Test
    public void classBasedProxyTest() {
        ProxyFactory weaver = new ProxyFactory(new Executable());
        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();
        advisor.setMappedName("execute");
        advisor.setAdvice(new PerformanceMethodInterceptor());
        weaver.addAdvisor(advisor);
        Executable proxyObject = (Executable) weaver.getProxy();
        proxyObject.execute();
        System.out.println(proxyObject.getClass());
    }

    @Test
    public void cglibProxyWithInterface() {
        ProxyFactory factory = new ProxyFactory(new MockTask());
        factory.setProxyTargetClass(true);
        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();
        advisor.setMappedName("execute");
        advisor.setAdvice(new PerformanceMethodInterceptor());
        factory.addAdvisor(advisor);
        MockTask proxyObject = (MockTask) factory.getProxy();
        proxyObject.execute();
        System.out.println(proxyObject.getClass());
    }

    @Test
    public void weaveIntroductionInterfaceBasedTest() {
        ProxyFactory factory = new ProxyFactory(new Developer());
        factory.setInterfaces(IDeveloper.class, ITester.class);
        TesterFeatureIntroductionInterceptor advice = new TesterFeatureIntroductionInterceptor();
        factory.addAdvice(advice);

        Object proxy = factory.getProxy();
        ((ITester) proxy).testSoftware();
        ((IDeveloper) proxy).developSoftware();
    }

    @Test
    public void weaveIntroductionClassBasedTest() {
        ProxyFactory factory = new ProxyFactory(new Developer());
        factory.setProxyTargetClass(true);
        factory.setInterfaces(ITester.class);
        TesterFeatureIntroductionInterceptor advice = new TesterFeatureIntroductionInterceptor();
        factory.addAdvice(advice);

        Object proxy = factory.getProxy();
        ((ITester)proxy).testSoftware();
        ((Developer)proxy).developSoftware();
    }
}
