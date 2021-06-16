package com.google.proxy.proxy_design_pattern;

public class LaptopProxy implements Computer {
    @Override
    public void showType() {
        new Laptop("laptop").showType();
    }
}
