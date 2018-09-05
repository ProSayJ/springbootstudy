package com.prosayj.springboot.javase.base.day29_jdbc.code.demo2;


import com.prosayj.springboot.javase.base.day29_jdbc.code.jdbcutil.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class TestJDBCUtils {
	public static void main(String[] args)throws Exception {
		Connection con = JDBCUtils.getConnection();
		PreparedStatement pst = con.prepareStatement("SELECT sname FROM sort");
		ResultSet rs = pst.executeQuery();
		while(rs.next()){
			System.out.println(rs.getString("sname"));
		}
		JDBCUtils.close(con, pst, rs);
		/*List list = new XXXX()
		 * while(rs.next()){
			Sort s = new Sort(rs.getInt("")......);
			list.add(s);
		}
		 * */
	}
}
