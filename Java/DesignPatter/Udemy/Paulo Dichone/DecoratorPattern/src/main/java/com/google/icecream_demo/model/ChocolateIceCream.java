package com.google.icecream_demo.model;

import com.google.icecream_demo.service.IceCream;
import com.google.icecream_demo.service.IceCreamDecorator;

public class ChocolateIceCream extends IceCreamDecorator {
    public ChocolateIceCream(IceCream iceCream) {
        super(iceCream);
        System.out.println("Adding chocolate ice cream!");
    }

    @Override
    public double cost() {
        return 1.5 + super.cost();
    }
}
