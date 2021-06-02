package com.google.proxy_test;

import com.google.proxy.cglib.LaptopCallback;
import com.google.proxy.dynamic_proxy.ShowTypeInvocationHandler;
import com.google.proxy.proxy_design_pattern.*;
import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

import java.lang.reflect.Proxy;

public class ProxyDesignPatternTest {
    @Test
    public void staticProxyTest() {
        Computer laptopProxy = new LaptopProxy();
        Alien alien1 = new Alien(laptopProxy);
        alien1.getComputer().showType();
        System.out.println(alien1.getComputer());

        Computer desktopProxy = new DesktopProxy();
        Alien alien2 = new Alien(desktopProxy);
        alien2.getComputer().showType();
        System.out.println(alien2.getComputer());
    }

    @Test
    public void dynamicProxyTest() {
        Computer laptop = (Computer) Proxy.newProxyInstance(Computer.class.getClassLoader(), new Class<?>[] {Computer.class}, new ShowTypeInvocationHandler(new Laptop("laptop")));
        laptop.showType();
    }

    @Test
    public void cglibTest() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Laptop.class);
        enhancer.setCallback(new LaptopCallback());
        Laptop proxy = (Laptop) enhancer.create(new Class[]{String.class}, new Object[]{"laptop"});
        proxy.showType();
    }
}
