package com.google.jdbc_test.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 封装 JDBC 的一些配置，更加方便使用。 （PreparedStatement 版）
 *
 * @author Frank, Liao
 * @date 2021-1-25
 */
public class JDBCUtilsPreparedStatement {
    private static Connection connection;

    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    /**
     * 静态代码块，预加载。
     */
    static {
        InputStream inputStream = JDBCUtilsPreparedStatement.class.getClassLoader().getResourceAsStream("com/google/jdbc_test/db.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        url = properties.getProperty("url");
        user = properties.getProperty("user");
        password = properties.getProperty("password");
        driver = properties.getProperty("driver");

//        System.out.println("url: " + url + ", user: " + user + ", password: " + password + ", driver: " + driver);
    }

    public static void main(String[] args) {
        System.out.println("看看配置文件读取成功没有");
    }

    /**
     * 单例，获取数据库连接。
     *
     * @return 数据库连接
     */
    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 关闭资源。用于增删改等没有 ResultSet 的语句。
     *
     * @param connection 数据库连接
     * @param preparedStatement 语句
     */
    public static void close(Connection connection, PreparedStatement preparedStatement) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 重载。用于查询等有 ResultSet 的语句。
     *
     * @param connection 数据库连接
     * @param preparedStatement 语句
     * @param resultSet 结果集
     */
    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection = null;
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            preparedStatement = null;
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            resultSet = null;
        }
    }
}
