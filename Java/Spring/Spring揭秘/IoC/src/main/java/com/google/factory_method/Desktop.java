package com.google.factory_method;

public class Desktop implements Computer{
    @Override
    public String showMethod() {
        return "with desktop ... ";
    }
}
