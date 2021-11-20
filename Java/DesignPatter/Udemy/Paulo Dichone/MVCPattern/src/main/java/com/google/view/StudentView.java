package com.google.view;

import com.google.model.Student;

public class StudentView {
    public void printStudentDetails(Student student) {
        System.out.println("Roll NO: " + student.getRollNo());
        System.out.println("Name: " + student.getName());
    }
}
