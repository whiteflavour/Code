package com.google.dao;

import com.google.util.JDBCUtils;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 数据库接口，获取物品对应的价格
 *
 * @author Liao
 * @date 2021-2-26
 */
public class ShoppingDao {
    public BigDecimal getPrice(String objectName) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "select price from goods where name=?";

        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, objectName);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getBigDecimal(3);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection, preparedStatement, resultSet);
        }
        return BigDecimal.valueOf(0L);
    }
}
