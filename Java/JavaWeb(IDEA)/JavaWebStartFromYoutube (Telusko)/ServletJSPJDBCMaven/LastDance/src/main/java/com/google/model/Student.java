package com.google.model;

/**
 * 模型类。
 *
 * @author Liao
 * @date 2021-2-9
 */
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

    @Override
    public String toString() {
        return "your username : " + this.name;
    }
}
