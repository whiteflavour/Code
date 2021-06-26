package com.google;

import java.util.List;

public interface StudentMapper {
    // @Select("select * from student where id = #{id}")
    Student selectStudent(int id);

    // @Insert("insert into student(name, age) values(#{name}, #{age})")
    int insertStudent(Student student);

    // @Update("update student set name = #{name} where id = #{id}")
    int updateNameOfStudent(Student student);

    // @Select("select * from student")
    List<Student> selectAllStudents();

    // @Select("select * from student where id = #{value}")
    Student select(int id);

    List<Student> selectByName(String name);

    int delete(int id);
}
