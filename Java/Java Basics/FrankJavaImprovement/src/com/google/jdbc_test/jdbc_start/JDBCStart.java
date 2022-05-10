package com.google.jdbc_test.jdbc_start;

import java.sql.*;

public class JDBCStart {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_start";
    private static final String USER = "root";
    private static final String PASSWORD = "134679";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1. 加载驱动
        Class.forName("com.mysql.jdbc.Driver");

        // 2. 连接
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

        // 3. 卸货
        Statement statement = connection.createStatement();

        // 4. 执行 SQL 语句
        ResultSet resultSet = statement.executeQuery("SELECT * FROM `info`");

        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            int age = resultSet.getInt(3);

            System.out.println("id: " + id + ", name: " + name + ", age: " + age);
        }

        // 5. 关闭
        statement.close();
        connection.close();
    }
}
