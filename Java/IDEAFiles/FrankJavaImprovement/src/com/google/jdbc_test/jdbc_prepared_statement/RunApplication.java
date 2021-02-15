package com.google.jdbc_test.jdbc_prepared_statement;

import com.google.jdbc_test.util.JDBCUtilsPreparedStatement;

public class RunApplication {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        try {
            selectAll();
//            selectById();
//            insert();
//            deleteById();
            updateById();
        } finally {
            // 在这里关闭资源，因为要完成所有的操作之后才能关闭，否则只能进行一步操作，后面的操作都将不能进行。
            JDBCUtilsPreparedStatement.close(PreparedStatementQuery.getConnection(), PreparedStatementQuery.getPreparedStatement(), PreparedStatementQuery.getResultSet());
        }
    }

    /**
     * 根据 ID 查询，用户输入 ID 。
     */
    public static void selectById() {
        PreparedStatementQuery.selectById();
    }

    /**
     * 查询表中的所有数据。
     */
    public static void selectAll() {
        PreparedStatementQuery.selectAll();
    }

    /**
     * 插入一条数据。
     */
    public static void insert() {
        PreparedStatementUpdate.insert();
    }

    /**
     * 根据 ID 删除一条数据。
     */
    public static void deleteById() {
        PreparedStatementUpdate.deleteById();
    }

    /**
     * 清空表。
     */
    public static void truncate() {
        PreparedStatementUpdate.truncate();
    }

    /**
     * 根据 ID 更新一条数据。手动输入更新后的姓名和年龄。
     */
    public static void updateById() {
        PreparedStatementUpdate.updateById();
    }
}
