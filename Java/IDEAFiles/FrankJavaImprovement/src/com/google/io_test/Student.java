package com.google.io_test;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    private int age;
    private String name;
    private int id;

//    public Student() {}
//
//    public Student(int age, String name, int id) {
//        this.age = age;
//        this.name = name;
//        this.id = id;
//    }

    public static void main(String[] args) {
        Student student = new Student(10, "fuck", 1);
        int nAge = student.getAge();
        System.out.println(nAge);
    }
}