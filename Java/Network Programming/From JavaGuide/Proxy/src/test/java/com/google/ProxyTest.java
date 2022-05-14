package com.google;

import com.google.dynamic_proxy.cglib.AliSmsService;
import com.google.dynamic_proxy.cglib.CglibProxyFactory;
import com.google.dynamic_proxy.jdk_proxy.JdkProxyFactory;
import com.google.static_proxy.SmsProxy;
import com.google.static_proxy.SmsService;
import com.google.static_proxy.SmsServiceImpl;
import org.junit.Test;

public class ProxyTest {
    @Test
    public void testStaticProxy() {
        SmsService smsService = new SmsServiceImpl();
        SmsProxy smsProxy = new SmsProxy(smsService);
        smsProxy.send("Fuck");
    }

    @Test
    public void testJdkDynamicProxy() {
        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.send("AA");
    }

    @Test
    public void testCglibDynamicProxy() {
        AliSmsService aliSmsService = (AliSmsService) CglibProxyFactory.getProxy(AliSmsService.class);
        aliSmsService.send("Hello");
    }
}
