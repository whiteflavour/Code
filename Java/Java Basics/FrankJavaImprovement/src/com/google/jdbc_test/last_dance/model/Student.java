package com.google.jdbc_test.last_dance.model;

/**
 * The information of students.
 *
 * @author Liao
 * @date 2021-1-31
 */
public class Student {
    private int id = 0;
    private String name = null;
    private int age = 0;

    public Student() {}
    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }

    public String toString() {
        return "id: " + this.id + ", name: " + this.name + ", age: " + this.age;
    }
}
