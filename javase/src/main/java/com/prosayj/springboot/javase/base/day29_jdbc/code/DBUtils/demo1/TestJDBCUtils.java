package com.prosayj.springboot.javase.base.day29_jdbc.code.DBUtils.demo1;

import com.prosayj.springboot.javase.base.day29_jdbc.code.DBUtils.jdbcutil.JDBCUtilsConfig;

import java.sql.Connection;


public class TestJDBCUtils {
	public static void main(String[] args) {
		Connection con = JDBCUtilsConfig.getConnection();
		System.out.println(con);
	}
}
