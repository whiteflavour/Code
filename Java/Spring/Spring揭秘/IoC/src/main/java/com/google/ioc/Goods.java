package com.google.ioc;

public class Goods {
    private double price;

    public Goods() {
    }

    public Goods(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
