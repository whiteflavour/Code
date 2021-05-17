package com.google.custom_scopes;

import com.google.hierarchy.Apple;
import org.springframework.beans.factory.config.Scope;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.SimpleThreadScope;
import org.springframework.core.io.FileSystemResource;

public class BeanFactoryIocTest {
    public static void main(String[] args) {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(new FileSystemResource("src/main/resources/beans.xml"));

        Scope threadScope = new SimpleThreadScope();
        factory.registerScope("thread", threadScope);

        Apple apple = (Apple) factory.getBean("apple");
        System.out.println(apple.getShit());
    }
}
