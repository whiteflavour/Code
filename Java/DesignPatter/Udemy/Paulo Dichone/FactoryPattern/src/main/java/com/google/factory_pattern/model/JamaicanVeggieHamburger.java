package com.google.factory_pattern.model;

import com.google.factory_pattern.interfaces.Hamburger;

public class JamaicanVeggieHamburger extends Hamburger {
    public JamaicanVeggieHamburger() {
        super.setName("Jamaican Style Veggie Burger");
        super.setSauce("Spicy Jamaican Sauce");
        super.setBuns("Lettuce Wrap");
    }
}
