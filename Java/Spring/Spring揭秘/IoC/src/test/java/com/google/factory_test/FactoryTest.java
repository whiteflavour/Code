package com.google.factory_test;

import com.google.factory_method.Alien;
import com.google.factory_method.NextDayDateFactoryBean;
import org.junit.Test;
import static org.junit.Assert.*;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

import java.lang.reflect.InvocationTargetException;

public class FactoryTest {
    @Test
    public void alienTest() {
        GenericApplicationContext context = new GenericApplicationContext();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        reader.loadBeanDefinitions("beans.xml");
        context.refresh();

        Alien alien = (Alien) context.getBean("alien");
    }

    @Test
    public void nextDayTest() throws Exception {
        GenericApplicationContext context = new GenericApplicationContext();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        reader.loadBeanDefinitions("beans.xml");
        context.refresh();

        // NextDay nextDay = (NextDay) context.getBean("nextDay");
        // nextDay.showNextDay();

        Object nextDayDate = context.getBean("nextDayDateFactory");
        assertTrue(nextDayDate instanceof Integer);

        Object factoryBean = context.getBean("&nextDayDateFactory");
        assertTrue(factoryBean instanceof FactoryBean);
        assertTrue(factoryBean instanceof NextDayDateFactoryBean);

        Object factoryValue = ((NextDayDateFactoryBean) factoryBean).getObject();
        assertTrue(factoryValue instanceof Integer);

        assertNotSame(nextDayDate, factoryValue);
        assertEquals(nextDayDate, factoryValue);
    }

    @Test
    public void beanWrapperTest() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Object alien = Class.forName("com.google.factory_method.Alien").getDeclaredConstructor().newInstance();
        Object laptop = Class.forName("com.google.factory_method.Laptop").getDeclaredConstructor().newInstance();

        BeanWrapper alienWrapper = new BeanWrapperImpl(alien);
        alienWrapper.setPropertyValue("laptop", laptop);

        assertTrue(alienWrapper.getWrappedInstance() instanceof Alien);
        assertSame(alien, alienWrapper.getWrappedInstance());
        assertSame(laptop, alienWrapper.getPropertyValue("laptop"));
    }
}
