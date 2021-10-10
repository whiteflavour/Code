package com.google.factory_pattern.model;

import com.google.factory_pattern.interfaces.Hamburger;

public class JamaicanCheeseHamburger extends Hamburger {
    public JamaicanCheeseHamburger() {
        super.setName("Jamaican Style Cheese Burger");
        super.setSauce("Spicy Jamaican Sauce");
        super.setBuns("Cookie Dough Buns");
    }
}
