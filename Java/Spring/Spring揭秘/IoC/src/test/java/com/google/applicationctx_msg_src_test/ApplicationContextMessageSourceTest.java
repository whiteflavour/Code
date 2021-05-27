package com.google.applicationctx_msg_src_test;

import org.junit.Test;
import static org.junit.Assert.*;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.context.support.StaticMessageSource;

import java.util.Locale;

public class ApplicationContextMessageSourceTest {
    @Test
    public void applicationCtxMsgSrcTest() {
        GenericApplicationContext context = new GenericApplicationContext();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        reader.loadBeanDefinitions("beans.xml");
        context.refresh();

        String fileMenuName = context.getMessage("menu.file", new Object[] {"F"}, Locale.US);
        String editMenuName = context.getMessage("menu.edit", null, Locale.US);

        assertEquals("File(F)", fileMenuName);
        assertEquals("Edit", editMenuName);
    }

    @Test
    public void MessageSourceTest() {
        StaticMessageSource staticMessageSource = new StaticMessageSource();
        staticMessageSource.addMessage("menu.file", Locale.US, "File({0})");
        staticMessageSource.addMessage("menu.edit", Locale.US, "Edit");

        assertEquals("File(f)", staticMessageSource.getMessage("menu.file", new Object[] {"f"}, Locale.US));
        assertEquals("Edit", staticMessageSource.getMessage("menu.edit", null, Locale.US));

        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("i18n/messages");

        assertEquals("File(F)", messageSource.getMessage("menu.file", new Object[] {"F"}, Locale.US));

        ReloadableResourceBundleMessageSource reloadableMessageSource = new ReloadableResourceBundleMessageSource();
        reloadableMessageSource.setBasename("file:src/main/resources/i18n/messages");

        assertEquals("File(Cao)", reloadableMessageSource.getMessage("menu.file", new Object[] {"Cao"}, Locale.US));
    }
}
