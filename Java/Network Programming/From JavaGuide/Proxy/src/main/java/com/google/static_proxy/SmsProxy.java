package com.google.static_proxy;

public class SmsProxy implements SmsService {
    private final SmsService smsService;

    public SmsProxy(SmsService smsService) {
        this.smsService = smsService;
    }

    @Override
    public String send(String msg) {
        System.out.println("Before method send()");
        smsService.send(msg);
        System.out.println("After method send()");
        return null;
    }
}
