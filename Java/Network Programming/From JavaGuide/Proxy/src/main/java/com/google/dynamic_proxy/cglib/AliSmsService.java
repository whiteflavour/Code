package com.google.dynamic_proxy.cglib;

public class AliSmsService {
    public String send(String msg) {
        System.out.println("Sending message: " + msg);
        return msg;
    }
}
