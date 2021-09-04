package com.google.example;

public class ChineseObserver implements Observer {
    private String name = getClass().getSimpleName();

    @Override
    public void update() {
        System.out.println("China got");
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
