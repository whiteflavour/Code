package com.google.hierarchy;

public class Banana extends Fruit {
    public Banana() {
    }

    public Banana(String color, boolean isGood, int id, double price, double weight, double length, double height) {
        super(color, isGood, id, price, weight, length, height);
    }

    @Override
    public String getFlavor() {
        return "banana: " + super.getFlavor();
    }
}
