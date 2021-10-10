package com.google.icecream_demo.model;

import com.google.icecream_demo.service.IceCream;
import com.google.icecream_demo.service.IceCreamDecorator;

public class MintIceCream extends IceCreamDecorator {
    public MintIceCream(IceCream iceCream) {
        super(iceCream);
        System.out.println("Adding mint ice cream!");
    }

    @Override
    public double cost() {
        return 2 + super.cost();
    }
}
