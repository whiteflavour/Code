package com.google.model;

public class MarioCharacterReceiver {
    private String name;

    public MarioCharacterReceiver(String name) {
        this.name = name;
    }

    public void moveUp() {
        System.out.println(name + " moving up!");
    }

    public void moveLeft() {
        System.out.println(name + " moving left!");
    }
}
