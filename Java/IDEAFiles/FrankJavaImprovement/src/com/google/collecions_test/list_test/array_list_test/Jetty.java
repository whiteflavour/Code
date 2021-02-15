package com.google.collecions_test.list_test.array_list_test;

public class Jetty {
    private String name = null;
    private int age = 0;

    public Jetty() {}
    public Jetty(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return this.name + " " + this.age;
    }
}
