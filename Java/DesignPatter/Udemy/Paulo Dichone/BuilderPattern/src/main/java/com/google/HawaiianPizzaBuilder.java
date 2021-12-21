package com.google;

/**
 * Concrete Builder
 */
public class HawaiianPizzaBuilder extends PizzaBuilder {
    @Override
    public PizzaBuilder buildDough() {
        getPizza().setDough("cross");
        return this;
    }

    @Override
    public PizzaBuilder buildSauce() {
        getPizza().setSauce("mild");
        return this;
    }

    @Override
    public PizzaBuilder buildTopping() {
        getPizza().setTopping("ham + pineapple");
        return this;
    }
}
