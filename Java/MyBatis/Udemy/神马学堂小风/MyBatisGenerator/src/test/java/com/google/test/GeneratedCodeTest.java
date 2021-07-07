package com.google.test;

import com.google.mapper.FruitShopOrderMapper;
import com.google.mapper.StudentMapper;
import com.google.model.FruitShopOrder;
import com.google.model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class GeneratedCodeTest {
    @Test
    public void testStudent() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            Student student = mapper.selectByPrimaryKey(2L);
            System.out.println(student);
        }
    }

    @Test
    public void testFruitShopOrder() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            FruitShopOrderMapper mapper = session.getMapper(FruitShopOrderMapper.class);
            List<FruitShopOrder> results = mapper.selectAll();
            for (FruitShopOrder result : results) {
                System.out.println(result);
            }
        }
    }
}
