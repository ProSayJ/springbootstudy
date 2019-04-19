package com.prosayj.springboot._04_Java高并发编程详解._01_._06_jdbcexample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/19 12:08
 * @since 1.0.0
 */
public class RecordQuery {
    private final Connection connection;

    public RecordQuery(Connection connection) {
        this.connection = connection;
    }

    public <T> T query(RowHandler<T> handler, String sql, Object... params) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            int index = 1;
            for (Object param : params) {
                preparedStatement.setObject(index++, param);
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            return handler.handle(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
