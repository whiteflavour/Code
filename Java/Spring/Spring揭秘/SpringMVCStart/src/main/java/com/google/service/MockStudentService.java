package com.google.service;

import com.google.model.Student;

import java.util.ArrayList;
import java.util.List;

public class MockStudentService implements StudentService {
    @Override
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Fuck", 19));
        students.add(new Student(2, "Rose", 16));
        students.add(new Student(3, "Jenny", 18));
        return students;
    }
}
