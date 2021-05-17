package com.google.hierarchy;

public abstract class Fruit extends Shit {
    private String color;
    private boolean isGood;
    private int id;
    private double price;
    private double weight;
    private double length;
    private double height;
    private Shit shit;

    public Fruit() {
    }

    public Fruit(String color, boolean isGood, int id, double price, double weight, double length, double height) {
        this.color = color;
        this.isGood = isGood;
        this.id = id;
        this.price = price;
        this.weight = weight;
        this.length = length;
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isGood() {
        return isGood;
    }

    public void setGood(boolean good) {
        isGood = good;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Shit getShit() {
        return shit;
    }

    public void setShit(Shit shit) {
        this.shit = shit;
    }
}
