package com.google.mapper;

import com.google.model.Result;
import com.google.model.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> selectByNameOrAge(Student student);

    List<Student> selectIn(Student student);

    List<Result> selectStuAndOrder();
}
