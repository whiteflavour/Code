package com.google;

public class OrderingPizza {
    public static void main(String[] args) {
        PizzaBuilder hawaiianPizzaBuilder = new HawaiianPizzaBuilder();
        PizzaBuilder spicyPizzaBuilder = new SpicyPizzaBuilder();

        Waiter waiter = new Waiter();
        waiter.setPizzaBuilder(spicyPizzaBuil[3,4,6,7,3,4,6,7,4,9,5,4,3,4,5]der);
        waiter.constructPizza();

        Pizza pizza = waiter.getPizza();
        System.out.println(pizza);
    }
}
