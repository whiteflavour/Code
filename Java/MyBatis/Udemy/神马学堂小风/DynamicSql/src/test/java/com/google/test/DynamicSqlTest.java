package com.google.test;

import com.google.mapper.StudentMapper;
import com.google.model.FruitShopOrder;
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

    @Test
    public void testSelectResultMap() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            List<FruitShopOrder> results = mapper.selectStuAndOrderResultMap();
            for (FruitShopOrder result : results) {
                System.out.println("id: " + result.getStuId() + ", name: "
                        + result.getStudent().getName() + ", price: "
                        + result.getPrice() + ", datetime: "
                        + result.getDatetime());
            }
        }
    }

    @Test
    public void testSelectOrders() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            List<Student> students = mapper.selectOrders();
            for (Student student : students) {
                System.out.println("用户信息：");
                System.out.println("name: " + student.getName() + ", age: " + student.getAge());
                System.out.println("订单信息：");
                for (FruitShopOrder order : student.getOrders()) {
                    System.out.println("order id: " + order.getId()
                            + ", price: " + order.getPrice()
                            + ", datetime: " + order.getDatetime());
                }
                System.out.println();
            }
        }
    }
}
