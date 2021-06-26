package com.google.dao;

import com.google.model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class StudentDaoImpl implements StudentDao {
    @Override
    public void selectStudent(int id) {
        SqlSessionFactory sqlSessionFactory;
        SqlSession session = null;
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            session = sqlSessionFactory.openSession();
            Student student = session.selectOne("selectStudentById", 1);
            System.out.println(student);
        } catch (IOException e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
