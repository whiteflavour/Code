package com.google.dao;

import com.google.model.Goods;
import com.google.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 访问数据库。
 *
 * @author Liao
 * @date 2021-3-6
 */
public class ShoppingDao {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    /**
     * 获取每件物品所组成的数组列表。
     *
     * @return 包含所有物品的数组列表
     */
    public ArrayList<Goods> getGoods() {
        ArrayList<Goods> goods = new ArrayList<>();

        String sql = "select * from goods";
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                goods.add(new Goods(resultSet.getInt(1), resultSet.getString(2), resultSet.getBigDecimal(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection, preparedStatement, resultSet);
        }
        return goods;
    }
}
