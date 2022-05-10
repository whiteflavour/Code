package com.google.jdbc_test.jdbc_prepared_statement;

import com.google.jdbc_test.util.JDBCUtilsPreparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * 查询，通过 PreparedStatement 对象实现。
 *
 * @author Frank, Liao
 * @date 2021-1-25
 */
public class PreparedStatementQuery {
    private static Connection connection = JDBCUtilsPreparedStatement.getConnection();
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet = null;

    private static Scanner scanner;

    /**
     * getter.
     *
     * @return 数据库连接
     */
    public static Connection getConnection() {
        return connection;
    }

    /**
     * getter.
     *
     * @return PreparedStatement
     */
    public static PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }

    /**
     * getter.
     *
     * @return 结果集
     */
    public static ResultSet getResultSet() {
        return resultSet;
    }

    /**
     * 根据 ID 查询，手动输入 ID 。
     */
    public static void selectById() {
        System.out.println("输入要查询的 id: ");
        scanner = new Scanner(System.in);
        int id = scanner.nextInt();

        String sql = "SELECT * FROM info WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString(2);
                int age = resultSet.getInt(3);

                System.out.println("id: " + id + ", name: " + name + ", age: " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } /*finally {
            JDBCUtilsPreparedStatement.close(connection, preparedStatement, resultSet);
        }*/
    }

    /**
     * 查询表中的所有数据。
     */
    public static void selectAll() {
        String sql = "SELECT * FROM info";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println("id: " + resultSet.getInt(1) + ", name: " + resultSet.getString(2) + ", age: " + resultSet.getInt(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } /*finally {
            JDBCUtilsPreparedStatement.close(connection, preparedStatement, resultSet);
        }*/
    }
}
