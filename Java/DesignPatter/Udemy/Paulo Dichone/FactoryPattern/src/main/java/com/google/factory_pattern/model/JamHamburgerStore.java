package com.google.factory_pattern.model;

import com.google.factory_pattern.interfaces.Hamburger;
import com.google.factory_pattern.interfaces.HamburgerStore;

public class JamHamburgerStore extends HamburgerStore {
    @Override
    public Hamburger createHamburger(String type) {
        if (type.equalsIgnoreCase("cheese")) {
            return new JamaicanCheeseHamburger();
        } else if (type.equalsIgnoreCase("veggie")) {
            return new JamaicanVeggieHamburger();
        } else {
            return null;
        }
    }
}
