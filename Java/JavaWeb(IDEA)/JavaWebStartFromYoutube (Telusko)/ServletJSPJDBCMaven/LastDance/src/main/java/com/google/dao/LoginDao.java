package com.google.dao;

import com.google.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 数据库连接类。
 *
 * @author Liao, Navin
 * @date 2021-2-9
 */
public class LoginDao {
    /**
     * 查看该用户名和密码是否存在于数据库中，如果存在，则该 sql 语句可以查出结果，否则没有结果。
     * @param username 用户名
     * @param password 密码
     * @return 如果匹配，则返回 true，否则 false.
     */
    public boolean checkInfo(String username, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from info where username=? and password=?";
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection, preparedStatement, resultSet);
        }
        return false;
    }
}
