package com.google.test;

import com.google.icecream_demo.model.BasicIceCream;
import com.google.icecream_demo.model.ChocolateIceCream;
import com.google.icecream_demo.model.MintIceCream;
import com.google.icecream_demo.model.VanillaIceCream;
import com.google.icecream_demo.service.IceCream;
import org.junit.jupiter.api.Test;

public class IceCreamTest {
    @Test
    public void testIceCream() {
        IceCream basicIceCream = new BasicIceCream();
        System.out.println("Cost: " + basicIceCream.cost() + "$");
        IceCream vanillaIceCream = new VanillaIceCream(basicIceCream);
        System.out.println("Now cost: " + vanillaIceCream.cost() + "$");
        IceCream chocolateIceCream = new ChocolateIceCream(vanillaIceCream);
        System.out.println("Now cost: " + chocolateIceCream.cost() + "$");
        IceCream mintIceCream = new MintIceCream(chocolateIceCream);
        System.out.println("Now cost: " + mintIceCream.cost() + "$");
    }
}
