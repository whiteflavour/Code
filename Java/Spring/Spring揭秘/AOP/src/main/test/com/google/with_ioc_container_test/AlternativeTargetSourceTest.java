package com.google.with_ioc_container_test;

import com.google.weaving.interface_based.ITask;
import com.google.with_ioc_container.AlternativeTargetSource;
import org.junit.Test;
import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.ProxyFactory;

public class AlternativeTargetSourceTest {
    @Test
    public void alternativeTargetSourceTest() {
        ITask task1 = new ITask() {
            @Override
            public void execute() {
                System.out.println("execute in task1 ... ");
            }
        };
        ITask task2 = new ITask() {
            @Override
            public void execute() {
                System.out.println("execute in task2 ... ");
            }
        };

        ProxyFactory factory = new ProxyFactory();
        TargetSource targetSource = new AlternativeTargetSource(task1, task2);
        factory.setTargetSource(targetSource);
        Object proxy = factory.getProxy();
        ((ITask)proxy).execute();
        ((ITask)proxy).execute();
        ((ITask)proxy).execute();
        ((ITask)proxy).execute();
        ((ITask)proxy).execute();
    }
}
