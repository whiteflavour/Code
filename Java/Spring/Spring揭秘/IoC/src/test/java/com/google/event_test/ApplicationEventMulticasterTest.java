package com.google.event_test;

import com.google.event.ApplicationMethodMulticaster;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

public class ApplicationEventMulticasterTest {
    @Test
    public void applicationEventMulticasterTest() {
        GenericApplicationContext context = new GenericApplicationContext();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        reader.loadBeanDefinitions("beans.xml");
        context.refresh();

        ApplicationMethodMulticaster eventMulticaster = (ApplicationMethodMulticaster) context.getBean("applicationMethodMulticaster");
        eventMulticaster.methodToMonitor();
    }
}
