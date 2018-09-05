package com.prosayj.springboot.javase.base.day30_jdbc.code.demo1;

import com.prosayj.springboot.javase.base.day30_jdbc.code.jdbcutil.JDBCUtilsConfig;

import java.sql.Connection;


public class TestJDBCUtils {
	public static void main(String[] args) {
		Connection con = JDBCUtilsConfig.getConnection();
		System.out.println(con);
	}
}
