package com.prosayj.springboot.mybatis3.v1;

import java.sql.*;

/**
 * @author lijun
 * @since 2018-04-02 9:54
 */
public class JunliSimpleExecutor implements JunliExecutor {
    @Override
    public <T> T query(String statement, String params) {


        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Test test = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mybatis3?serverTimezone=UTC&characterEncoding=UTF-8&serverTimezone=Hongkong", "root", "root");
            preparedStatement = connection.prepareStatement(String.format(statement, Integer.parseInt(params)));
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                test = new Test();
                test.setId(rs.getInt(1));
                test.setNums(rs.getInt(2));
                test.setName(rs.getString(3));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != connection) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return (T) test;
    }
}
