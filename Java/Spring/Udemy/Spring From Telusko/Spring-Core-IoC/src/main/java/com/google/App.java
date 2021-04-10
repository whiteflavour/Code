package com.google;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class App {
    public static void main(String[] args) {
//        BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
        //ApplicationContext factory = new ClassPathXmlApplicationContext("file:F:\\Code\\Java\\Spring\\Udemy\\Spring From Telusko\\Spring-Framework-Start\\src\\main\\java\\spring.xml");

        ApplicationContext factory = new ClassPathXmlApplicationContext("file:src/main/java/spring.xml");

        Alien alien = (Alien)factory.getBean("alien");
        alien.code();
        System.out.println(alien.getAge());
    }
}
