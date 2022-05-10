package com.google.collecions_test.stu_manage_sys_homework;

/**
 * The class including stuID and the name of students.
 *
 * @date 2021-1-19
 * @author Liao
 */
public class Student {
    private int stuID = 0;
    private String name = null;

    public Student() {}
    public Student(int stuID, String name) {
        this.stuID = stuID;
        this.name = name;
    }

    public int getStuID() {
        return this.stuID;
    }
    public String getName() {
        return this.name;
    }

    public void setStuID(int stuID) {
        this.stuID = stuID;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "ID: " + this.getStuID() + ", Name: " + this.getName();
    }
}
