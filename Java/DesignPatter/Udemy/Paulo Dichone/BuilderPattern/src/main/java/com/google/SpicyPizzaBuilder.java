package com.google;

/**
 * Concrete Builder
 */
public class SpicyPizzaBuilder extends PizzaBuilder {
    @Override
    public PizzaBuilder buildDough() {
        getPizza().setDough("pan baked");

        // 这样就可以使用链式调用
        return this;
    }

    @Override
    public PizzaBuilder buildSauce() {
        getPizza().setSauce("hot");
        return this;
    }

    @Override
    public PizzaBuilder buildTopping() {
        getPizza().setTopping("pepperoni + salami");
        return this;
    }
}
