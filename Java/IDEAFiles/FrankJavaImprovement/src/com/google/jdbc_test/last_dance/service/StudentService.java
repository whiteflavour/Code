package com.google.jdbc_test.last_dance.service;

import com.google.jdbc_test.last_dance.model.Student;
import com.google.jdbc_test.util.JDBCUtilsPreparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Some functions to manage students.
 *
 * @author Liao
 * @date 2021-1-31
 */
public class StudentService {
    private static Connection connection = JDBCUtilsPreparedStatement.getConnection();
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;
    private static Scanner scanner = new Scanner(System.in);

    /**
     * 返回连接对象，用于后面关闭资源。
     *
     * @return 连接对象
     */
    public static Connection getConnection() {
        return connection;
    }

    /**
     * 返回对象，用于关闭资源。
     *
     * @return PreparedStatement
     */
    public static PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }

    /**
     * 返回结果集，用于关闭资源。
     *
     * @return 结果集
     */
    public static ResultSet getResultSet() {
        return resultSet;
    }

    /**
     * 显示所有学生的信息。
     */
    public static void selectAll() {
        String sql = "SELECT * FROM info";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Student student = new Student(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
                System.out.println(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据 id 查询学生的信息。
     */
    public static void selectById() {
        String sql = "SELECT * FROM info WHERE id=?";
        try {
            preparedStatement = connection.prepareStatement(sql);

            System.out.println("请输入 id: ");
            int id = scanner.nextInt();

            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(new Student(id, resultSet.getString(2), resultSet.getInt(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 插入一个学生
     *
     * @return true if insert success
     */
    public static boolean insert() {
        String sql = "INSERT INTO info(`name`,age) VALUES(?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);

            System.out.println("请先输入姓名，再输入年龄，并用回车隔开: ");
            String name = scanner.next();
            int age = scanner.nextInt();

            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 根据 id 删除一个学生
     *
     * @return true if delete success
     */
    public static boolean delete() {
        String sql = "DELETE FROM info WHERE id=?";
        try {
            preparedStatement = connection.prepareStatement(sql);

            System.out.println("输入要删除的 id: ");
            int id = scanner.nextInt();

            preparedStatement.setInt(1, id);
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 清空学生信息
     *
     * @return true if truncate success
     */
    public static boolean truncate() {
        String sql = "TRUNCATE TABLE info";
        int isSure = 0;
        System.out.println("确定清空表吗？确定请输入1，其他请输入0: ");
        isSure = scanner.nextInt();
        if (isSure == 1) {
            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.executeUpdate();

                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 根据 id 修改学生姓名和年龄
     *
     * @return true if update success
     */
    public static boolean update() {
        String sql = "UPDATE info SET `name`=?,age=? WHERE id=?";
        try {
            preparedStatement = connection.prepareStatement(sql);

            System.out.println("输入要修改信息的学生的 id，然后再输入修改后的姓名，最后输入修改后的年龄，并依次用回车隔开: ");
            int id = scanner.nextInt();
            String name = scanner.next();
            int age = scanner.nextInt();

            preparedStatement.setInt(3, id);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 根据 id 修改学生姓名
     *
     * @return true if update success
     */
    public static boolean updateName() {
        String sql = "UPDATE info SET `name`=? WHERE id=?";
        try {
            preparedStatement = connection.prepareStatement(sql);

            System.out.println("输入要修改信息的学生的 id，然后再输入修改后的姓名,并使用回车隔开: ");
            int id = scanner.nextInt();
            String name = scanner.next();

            preparedStatement.setInt(2, id);
            preparedStatement.setString(1, name);
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 根据 id 修改学生年龄
     *
     * @return true if update success
     */
    public static boolean updateAge() {
        String sql = "UPDATE info SET age=? WHERE id=?";
        try {
            preparedStatement = connection.prepareStatement(sql);

            System.out.println("输入要修改信息的学生的 id，然后输入修改后的年龄，并使用回车隔开: ");
            int id = scanner.nextInt();
            int age = scanner.nextInt();

            preparedStatement.setInt(2, id);
            preparedStatement.setInt(1, age);
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
