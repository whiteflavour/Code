package com.google.icecream_demo.model;

import com.google.icecream_demo.service.IceCream;

public class BasicIceCream implements IceCream {
    public BasicIceCream() {
        System.out.println("Your basic ice cream!");
    }

    @Override
    public double cost() {
        return 0.5;
    }
}
