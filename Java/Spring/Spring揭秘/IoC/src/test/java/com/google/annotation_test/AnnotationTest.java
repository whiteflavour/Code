package com.google.annotation_test;

import com.google.annotation.Alien;
import com.google.annotation.Laptop;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

public class AnnotationTest {
    @Test
    public void annotationTest() {
        GenericApplicationContext context = new GenericApplicationContext();
        XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(context);
        xmlReader.loadBeanDefinitions("annotation/beans.xml");
        context.refresh();

        Alien alien = (Alien) context.getBean("alien");
        Laptop laptop = alien.getLaptop();
        System.out.println(laptop.showMethod());
    }
}
