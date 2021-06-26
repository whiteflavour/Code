package com.google;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StudentTest {
    @Test
    public void selectTest() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            Student student = mapper.select(1);
            System.out.println(student);
        }
    }

    @Test
    public void insertTest() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            mapper.insertStudent(new Student("func", 15));
            session.commit();
        }
    }

    @Test
    public void updateTest() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        Student student = new Student();
        student.setId(2);
        student.setName("fucker");
        try (SqlSession session = sqlSessionFactory.openSession()) {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            mapper.updateNameOfStudent(student);
            session.commit();
        }
    }

    @Test
    public void selectAllTest() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            List<Student> results = mapper.selectAllStudents();
            System.out.println(results);
        }
    }

    @Test
    public void selectByNameTest() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            List<Student> results = mapper.selectByName("f%");
            System.out.println(results);
        }
    }

    @Test
    public void deleteTest() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            mapper.delete(10);
            session.commit();
        }
    }
}
