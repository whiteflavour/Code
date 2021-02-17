package com.google.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 数据库连接工具类，使代码具有复用性。
 *
 * @author Liao
 * @date 2021-2-9
 *
 * @update 2021-2-11 Liao
 *  fixed java.lang.NoClassDefFoundError: Could not initialize class com.google.util.JDBCUtils.
 *      by replace getSystemResourceAsStream() method by getResourceAsStream() method.
 *
 * @update 2021-2-17 Liao
 *  fixed No suitable driver found for jdbc:mysql://localhost:3306/login?characterEncoding=utf8
 *      by adding Class.forName() method before DriverManager.getConnection() method
 *      in getConnection() function.
 */
public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    // 静态代码块，预加载代码。
    static {
        // 使用 getResourceAsStream() 方法代替 getSystemResourceAsStream() 方法。
        // 原因：webapp 是一个目录层级，使用 SystemResource 方法在运行时只能找第一层。
        // 一般使用 Resource 方法 代替 SystemResource 方法，因为它使用与代码所属类相同的类加载器，即：Resource 方法包含 SystemResource 方法。
        InputStream inputStream = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            driver = properties.getProperty("driver");

            // 检查，看是否读取配置文件成功。
//            System.out.println("url: " + url + "\nuser: " + user + "\npassword: " + password + "\ndriver: " + driver);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 测试资源文件是否读取成功。
     */
    public static void test() {
        System.out.println("come on");
    }

    /**
     * 获取数据库连接
     * @return 数据库连接 Connection
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        // 加载驱动，此步骤很重要。★
        Class.forName(driver);
        return DriverManager.getConnection(url, user, password);
    }

    public static void close(Connection connection, PreparedStatement preparedStatement) {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 重载
     * @param connection 数据库连接
     * @param preparedStatement preparedStatement
     */
    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
