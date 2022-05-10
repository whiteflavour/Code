package com.google.jdbc_test.jdbc_start;

import com.google.jdbc_test.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Testing JDBC update.
 *
 * @author Frank, Liao
 * @date 2021-1-24
 */
public class JDBCUpdateTest {
    public Connection connection;
    public Statement statement;

    /**
     * Testing insert.
     *
     * @author Frank, Liao
     * @date 2021-1-24
     */
    @Test
    public void insertTest() {
        try {
            connection = JDBCUtils.getConnection();
            statement = connection.createStatement();

            String sql = "INSERT INTO info(`name`,age) VALUES('去你妈的',16)";

            int affectedRows = statement.executeUpdate(sql);

            if (affectedRows > 0) {
                System.out.println("Insert success! ");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                JDBCUtils.close(connection, statement);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * Testing delete.
     *
     * @author Frank, Liao
     * @date 2021-1-24
     */
    @Test
    public void deleteTest() {
        try {
            connection = JDBCUtils.getConnection();
            statement = connection.createStatement();

            String sql = "DELETE FROM info WHERE id=6";

            int affectedRows = statement.executeUpdate(sql);

            if (affectedRows > 0) {
                System.out.println("Delete success! ");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                JDBCUtils.close(connection, statement);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * Testing update.
     *
     * @author Frank, Liao
     * @date 2021-1-24
     */
    @Test
    public void updateTest() {
        try {
            connection = JDBCUtils.getConnection();
            statement = connection.createStatement();

            String sql = "UPDATE info SET `name`='Fuck' WHERE id = 7";

            int affectedRows = statement.executeUpdate(sql);

            if (affectedRows > 0) {
                System.out.println("Already updated! ");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                JDBCUtils.close(connection, statement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Testing query.
     *
     * @author Frank, Liao
     * @date 2021-1-25
     */
    @Test
    public void queryTest() {
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            statement = connection.createStatement();

            resultSet = statement.executeQuery("SELECT * FROM info");

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int age = resultSet.getInt(3);

                System.out.println("id: " + id + ", name, " + name + ", age: " + age);
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
