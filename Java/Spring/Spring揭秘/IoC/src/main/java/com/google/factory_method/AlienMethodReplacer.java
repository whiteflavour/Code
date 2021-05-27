package com.google.factory_method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class AlienMethodReplacer implements MethodReplacer {
    private static final transient Log logger = LogFactory.getLog(AlienMethodReplacer.class);

    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        logger.info("before executing method[" + method.getName() + "] on Object[" + obj.getClass().getName() + "]. ");

        System.out.println("sorry, we will do nothing this time. ");

        logger.info("end of executing method[" + method.getName() + "] on Object[" + obj.getClass().getName() + "]. ");

        return null;
    }
}
