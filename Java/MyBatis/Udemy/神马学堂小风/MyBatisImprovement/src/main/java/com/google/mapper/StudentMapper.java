package com.google.mapper;

import com.google.model.AnotherStudent;
import com.google.model.Student;
import com.google.model.StudentWrapper;

public interface StudentMapper {
    Student selectStudentById(int id);

    void insertStudentByWrapper(StudentWrapper studentWrapper);

    void insertStudentByName(String name);

    AnotherStudent selectAnotherStudent(int id);
}
