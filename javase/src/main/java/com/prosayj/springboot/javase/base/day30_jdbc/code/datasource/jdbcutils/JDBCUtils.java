package com.prosayj.springboot.javase.base.day30_jdbc.code.datasource.jdbcutils;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
public class JDBCUtils{
	private static BasicDataSource datasource = new BasicDataSource();
	
	static{
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/bunuo");
		datasource.setUsername("root");
		datasource.setPassword("root");
		datasource.setInitialSize(10);
		datasource.setMaxActive(8);
		datasource.setMaxIdle(5);
		datasource.setMinIdle(1);
	}
	
	
	public static DataSource getDataSource(){
		return datasource;
	}
}
