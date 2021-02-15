package com.google.jdbc_test.jdbc_prepared_statement;

import com.google.jdbc_test.util.JDBCUtilsPreparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * 增删改，通过 PreparedStatement 对象实现。
 *
 * @author Frank, Liao
 * @date 2021-1-25
 */
public class PreparedStatementUpdate {
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
     * getter.
     *
     * @return scanner
     */
    public static Scanner getScanner() {
        return scanner;
    }

    /**
     * 向表中插入数据，通过 PreparedStatement 对象实现。
     */
    public static void insert() {
        System.out.println("先输入要插入的姓名，再输入年龄，使用回车隔开：");
        scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int age = scanner.nextInt();

        String sql = "INSERT INTO info(`name`,age) VALUES(?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("insert success! ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    /**
     * 删除一条数据，通过 PreparedStatement 对象实现。
     */
    public static void deleteById() {
        System.out.println("输入要删除的 ID：");
        scanner = new Scanner(System.in);
        int id = scanner.nextInt();

        String sql = "DELETE FROM info WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("delete success! ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    /**
     * 清空表，并新建一个与旧表相同的空表。
     */
    public static void truncate() {
        String sql = "TRUNCATE TABLE info";
        try {
            preparedStatement = connection.prepareStatement(sql);
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("truncate success! ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据 ID 更新一条数据，并且需手动输入修改后的姓名和年龄，通过 PreparedStatement 对象实现。
     */
    public static void updateById() {
        System.out.println("先输入要修改的 ID，再输入修改后的姓名，最后再输入修改后的年龄，分别用回车隔开：");
        scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        String name = scanner.nextLine();
        int age = scanner.nextInt();
        String sql = "UPDATE info SET `name`=?,age=? WHERE id=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(3, id);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("update success! ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
