package com.google.applicationctx_msg_src_test;

import com.google.i18n.Validator;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

public class ValidatorTest {
    @Test
    public void validatorTest() {
        GenericApplicationContext context = new GenericApplicationContext();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        reader.loadBeanDefinitions("beans.xml");
        context.refresh();

        Validator validator = (Validator) context.getBean("validator");
        System.out.println(validator.validate("fuck"));
    }
}
