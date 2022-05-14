package com.google.static_proxy;

public class SmsServiceImpl implements SmsService {
    @Override
    public String send(String msg) {
        System.out.println("Sending message: " + msg);
        return msg;
    }
}
