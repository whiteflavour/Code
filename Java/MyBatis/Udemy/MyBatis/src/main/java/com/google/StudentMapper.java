package com.google;

public interface StudentMapper {
    // @Select("select * from student where id = #{id}")
    Student selectStudent(int id);
    // @Insert("insert into student(name, age) values(#{name}, #{age})")
    int insertStudent(Student student);
    // @Update("update student set name = #{name} where id = #{id}")
    int updateNameOfStudent(Student student);
}
