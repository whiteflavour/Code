package com.google;

/**
 * Abstract Builder
 */
public abstract class PizzaBuilder {
    private Pizza pizza;

    public Pizza getPizza() {
        return pizza;
    }

    public PizzaBuilder createNewPizzaProduct() {
        pizza = new Pizza();
        return this;
    }

    public abstract PizzaBuilder buildDough();
    public abstract PizzaBuilder buildSauce();
    public abstract PizzaBuilder buildTopping();
}
