package com.google.model;

public class TomCharacterReceiver {
    private String name;

    public TomCharacterReceiver(String name) {
        this.name = name;
    }

    public void moveUp() {
        System.out.println(name + " moving up!");
    }

    public void moveLeft() {
        System.out.println(name + " moving left!");
    }
}
