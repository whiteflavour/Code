package com.google.ioc;

import com.google.custom_scopes.ScopeRegister;
import com.google.hierarchy.Apple;
import com.google.hierarchy.Banana;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

public class IocTest {
    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        new XmlBeanDefinitionReader(context).loadBeanDefinitions("beans.xml");
        context.refresh();

        Apple apple = (Apple) context.getBean("apple");
        Banana banana = (Banana) context.getBean("banana");

        System.out.println(apple.getColor() + ", " + banana.getColor());
        System.out.println(apple.getFlavor() + ", " + banana.getFlavor());
    }
}