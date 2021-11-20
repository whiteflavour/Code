package com.google.controller;

import com.google.model.Student;
import com.google.view.StudentView;

public class StudentController {
    private Student student;
    private StudentView studentView;

    public StudentController(Student student, StudentView studentView) {
        this.student = student;
        this.studentView = studentView;
    }

    public String getStudentName() {
        return student.getName();
    }

    public void setStudentName(String name) {
        student.setName(name);
    }

    public String getStudentRollNo() {
        return student.getRollNo();
    }

    public void setStudentRollNo(String rollNo) {
        student.setRollNo(rollNo);
    }

    public void updateView() {
        studentView.printStudentDetails(student);
    }
}
