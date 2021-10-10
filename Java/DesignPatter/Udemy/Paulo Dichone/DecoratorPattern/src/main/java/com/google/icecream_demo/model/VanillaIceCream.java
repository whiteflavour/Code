package com.google.icecream_demo.model;

import com.google.icecream_demo.service.IceCream;
import com.google.icecream_demo.service.IceCreamDecorator;

public class VanillaIceCream extends IceCreamDecorator {
    public VanillaIceCream(IceCream iceCream) {
        super(iceCream);
        System.out.println("Adding vanilla ice cream!");
    }

    @Override
    public double cost() {
        return 1.5 + super.cost();
    }
}
