package com.google.annotation;

import com.google.factory_method.Computer;
import org.springframework.stereotype.Component;

@Component
public class Desktop implements Computer {
    @Override
    public String showMethod() {
        return "with desktop ... ";
    }
}
