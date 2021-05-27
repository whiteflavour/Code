package com.google.custom_container_boot;

import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.beans.PropertyEditor;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CustomEditorConfigurerRunner {
    public static void main(String[] args) {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions("beans.xml");

        CustomEditorConfigurer configurer = new CustomEditorConfigurer();
        Map<Class<?>, Class<? extends PropertyEditor>> customerEditors = new HashMap<>();
        customerEditors.put(Date.class, DatePropertyEditor.class);
        configurer.setCustomEditors(customerEditors);
        configurer.postProcessBeanFactory(factory);

        DateFoo dateFoo = (DateFoo) factory.getBean("dateFoo");
        System.out.println(dateFoo.getDate());
    }
}
