package com.google.test;

import com.google.mapper.StudentMapper;
import com.google.model.Result;
import com.google.model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DynamicSqlTest {
    @Test
    public void testIfTag() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            Student student = new Student();
            // student.setName("f%");
            student.setAge(20);
            List<Student> results = mapper.selectByNameOrAge(student);
            System.out.println(results);
        }
    }

    @Test
    public void testForeach() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            Student student = new Student();
            student.setAges(new int[]{15, 19});
            System.out.println(mapper.selectIn(student));
        }
    }

    @Test
    public void testMultiSelect() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            List<Result> results = mapper.selectStuAndOrder();
            for (Result result : results) {
                System.out.println(result.getStuId() + ", " + result.getName() + ", "
                        + result.getPrice() + ", " + result.getDatetime());
            }
        }
    }
}
