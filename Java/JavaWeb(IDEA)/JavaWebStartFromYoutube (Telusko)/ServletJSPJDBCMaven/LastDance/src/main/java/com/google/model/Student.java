package com.google.model;

public class Student {
    private String name;

    public Student() {}
    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "your username : " + this.name;
    }
}
