package com.google.test;

import com.google.dao.StudentDaoImpl;
import com.google.mapper.StudentMapper;
import com.google.model.AnotherStudent;
import com.google.model.Student;
import com.google.model.StudentWrapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class StudentDaoImplTest {
    @Test
    public void testDao() {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        studentDao.selectStudent(1);
    }

    @Test
    public void testMapper() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            Student student = new Student("RNM", 20);
            StudentWrapper studentWrapper = new StudentWrapper(student);
            mapper.insertStudentByWrapper(studentWrapper);
            session.commit();
        }
    }

    @Test
    public void testInsert() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            mapper.insertStudentByName("ffffffffff");
            session.commit();
        }
    }

    @Test
    public void testResultMap() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            AnotherStudent student = mapper.selectAnotherStudent(1);
            System.out.println(student);
        }
    }
}
