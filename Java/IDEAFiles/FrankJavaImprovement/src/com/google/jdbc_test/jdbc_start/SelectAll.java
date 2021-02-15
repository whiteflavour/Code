package com.google.jdbc_test.jdbc_start;

import com.google.jdbc_test.util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectAll {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = JDBCUtils.getConnection();
            statement = connection.createStatement();

            resultSet = statement.executeQuery("SELECT * FROM info");

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int age = resultSet.getInt(3);

                System.out.println("id: " + id + ", name: " + name + ", age: " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCUtils.close(connection, statement, resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
