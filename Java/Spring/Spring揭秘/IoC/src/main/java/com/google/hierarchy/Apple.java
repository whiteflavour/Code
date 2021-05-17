package com.google.hierarchy;

public class Apple extends Fruit {
    public Apple() {
    }

    public Apple(String color, boolean isGood, int id, double price, double weight, double length, double height) {
        super(color, isGood, id, price, weight, length, height);
    }

    @Override
    public String getFlavor() {
        return "apple: " + super.getFlavor();
    }
}
