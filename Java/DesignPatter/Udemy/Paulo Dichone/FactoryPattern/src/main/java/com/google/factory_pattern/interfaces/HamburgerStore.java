package com.google.factory_pattern.interfaces;

public abstract class HamburgerStore {
    public Hamburger orderHamburger(String type) {
        Hamburger burger;
        burger = createHamburger(type);
        burger.prepare();
        burger.cook();
        burger.box();
        return burger;
    }

    protected abstract Hamburger createHamburger(String type);
}
