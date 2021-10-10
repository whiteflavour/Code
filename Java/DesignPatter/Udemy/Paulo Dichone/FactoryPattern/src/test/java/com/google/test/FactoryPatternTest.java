package com.google.test;

import com.google.factory_pattern.interfaces.Hamburger;
import com.google.factory_pattern.interfaces.HamburgerStore;
import com.google.factory_pattern.model.JamHamburgerStore;
import org.junit.jupiter.api.Test;

public class FactoryPatternTest {
    @Test
    public void testBurgerStore() {
        HamburgerStore hamburgerStore = new JamHamburgerStore();
        Hamburger jamaicanCheeseBurger = hamburgerStore.orderHamburger("cheese");
        System.out.println("Tom's " + jamaicanCheeseBurger.getName() + "!\n");

        Hamburger jamaicanVeggieBurger = hamburgerStore.orderHamburger("veggie");
        System.out.println("Rose's " + jamaicanVeggieBurger.getName() + "!\n");
    }
}
