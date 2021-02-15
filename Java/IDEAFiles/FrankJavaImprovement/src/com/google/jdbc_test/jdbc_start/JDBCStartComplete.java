package com.google.jdbc_test.jdbc_start;

import java.sql.*;

public class JDBCStartComplete {
    public static final String URL = "jdbc:mysql://localhost:3306/jdbc_start";
    public static final String USER = "root";
    public static final String PASSWORD = "134679";

    public static Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;

    public static void main(String[] args) {
        try {
            // 1. 加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 2. 返回路线
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // 3. 卸货
            statement = connection.createStatement();

            // 4. 操作货物
            // 返回的结果集相当于箱子，箱子装完产品肯定要关闭
            resultSet = statement.executeQuery("SELECT * FROM info");

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int age = resultSet.getInt(3);

                System.out.println("id: " + id + ", name: " + name + ", age: " + age);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
