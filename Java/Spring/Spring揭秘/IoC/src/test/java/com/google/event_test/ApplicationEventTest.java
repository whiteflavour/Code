package com.google.event_test;

import com.google.event.ApplicationMethodPublisher;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

public class ApplicationEventTest {
    @Test
    public void applicationEventTest() {
        GenericApplicationContext context = new GenericApplicationContext();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        reader.loadBeanDefinitions("beans.xml");
        context.refresh();

        ApplicationMethodPublisher publisher = (ApplicationMethodPublisher) context.getBean("applicationEventPublisher");

        publisher.methodToMonitor();
    }
}
