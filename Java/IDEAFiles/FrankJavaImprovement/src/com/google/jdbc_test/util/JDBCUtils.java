package com.google.jdbc_test.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    // 静态代码块预加载
    static {
        try {
            // 或者使用下面这句
            InputStream inputStream = JDBCUtils.class.getClassLoader().getResourceAsStream("com/google/jdbc_test/db.properties");

//            InputStream inputStream = ClassLoader.getSystemResourceAsStream("./com/google/demo/jdbc_test/db.properties");

            Properties properties = new Properties();
            properties.load(inputStream);

            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            driver = properties.getProperty("driver");

//            System.out.println("url: " + url + ", user: " + user + ", password:" + password + ", driver: " + driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试是否获取到了配置文件中的信息
     */
    public static void testProperties() {
        System.out.println("看看获得到了配置文件中的属性没有");
    }

    /**
     * 单例
     *
     * @return 数据库连接
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * 关闭资源，需重载
     * @param connection 数据库连接
     * @param statement 语句
     * @throws SQLException
     */
    public static void close(Connection connection, Statement statement) throws SQLException{
        if (statement != null) {
            statement.close();

            // 可有可无
//            statement = null;
        }
        if (connection != null) {
            connection.close();
        }
    }

    /**
     * 重载
     */
    public static void close(Connection connection, Statement statement, ResultSet resultSet) throws SQLException{
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
        if (resultSet != null) {
            resultSet.close();
        }
    }
}
