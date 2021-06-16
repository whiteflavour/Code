package com.google.with_ioc_container_test;

import com.google.weaving.interface_based.ITask;
import com.google.weaving.interface_based.MockTask;
import com.google.with_ioc_container.ICounter;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.target.HotSwappableTargetSource;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class WithIocContainer {
    @Test
    public void proxyFactoryBeanTest() {
        GenericApplicationContext context = new GenericApplicationContext();
        XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(context);
        xmlReader.loadBeanDefinitions(new ClassPathResource("beans.xml"));
        context.refresh();

        MockTask mockTask = (MockTask) context.getBean("taskProxy");
        ITask task = (ITask) context.getBean("taskProxy");
        System.out.println(task.getClass());
        task.execute();
        System.out.println(mockTask.getClass());
        mockTask.execute();
    }

    @Test
    public void introductionTest() {
        GenericApplicationContext context = new GenericApplicationContext();
        XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(context);
        xmlReader.loadBeanDefinitions(new ClassPathResource("beans.xml"));
        context.refresh();

        Object proxy1 = context.getBean("taskProxy");
        Object proxy2 = context.getBean("taskProxy");

        System.out.println(((ICounter)proxy1).getCounter());
        System.out.println(((ICounter)proxy1).getCounter());
        System.out.println(((ICounter)proxy2).getCounter());
    }
    @Test
    public void autoProxyCreatorTest() {
        GenericApplicationContext context = new GenericApplicationContext();
        XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(context);
        xmlReader.loadBeanDefinitions(new ClassPathResource("beans.xml"));
        context.refresh();

        ITask mockTask = (ITask) context.getBean("mockTask");
        mockTask.execute();
        ICounter counterImpl = (ICounter) context.getBean("counterImpl");
        System.out.println(counterImpl.getCounter());
        System.out.println(counterImpl.getCounter());
    }

    @Test
    public void targetSourceTest() throws Exception {
        GenericApplicationContext context = new GenericApplicationContext();
        XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(context);
        xmlReader.loadBeanDefinitions(new ClassPathResource("beans.xml"));
        context.refresh();

        Object proxy = context.getBean("targetProxy");
        Object task1 = ((Advised)proxy).getTargetSource().getTarget();
        Object task2 = ((Advised)proxy).getTargetSource().getTarget();

        System.out.println(task1);
        System.out.println(task2);
        assertNotSame(task1, task2);
    }
}
