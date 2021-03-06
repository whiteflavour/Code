package com.google.proxy.dynamic_proxy;

public class Laptop implements Computer {
    private String type;

    public Laptop(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void showType() {
        System.out.println(type);
    }
}
