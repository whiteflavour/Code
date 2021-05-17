package com.google.factory_method;

public class Laptop implements Computer {
    @Override
    public String showMethod() {
        return "with laptop ... ";
    }
}
