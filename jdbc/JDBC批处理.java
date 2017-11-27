//业务场景：大量书籍需要插入时，如果sql一条一条执行的话，速度会非常慢
//解决：批处理


package com.netease.course;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloJDBC {
	
	static final String JDBC_DRIVER = "org.postgresql.Driver";
	static String DB_URL = "jdbc:postgresql://localhost:5432/testjdbc";
	static final String USER = "postgres";
	static final String PASSWORD = "123456";
	
	public static void helloword() throws ClassNotFoundException{		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		DB_URL = DB_URL + "?useCursorFetch=true";
		
        // 1.装载驱动程序
		Class.forName(JDBC_DRIVER);
		// 2.建立数据库连接
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			// 3.执行SQL语句
			stmt = conn.createStatement();
			stmt.addBatch("insert into info(id, firstname, lastname)values(3, '雅琳', '李')");
			stmt.addBatch("insert into info(id, firstname, lastname)values(4, '锦波', '张')");
			stmt.executeBatch();
			stmt.clearBatch();
		} catch(SQLException e) {
			// 异常处理
			e.printStackTrace();
		} finally {
			// 5.清理环境(很重要）
			try {
			if(conn != null)
				conn.close();
			if(stmt != null)
				stmt.close();
			if(rs != null)
				rs.close();
			} catch(SQLException e) {
//				ignore
			}
		}
	}
	
	public static void main(String[] args)throws ClassNotFoundException {
		helloword();
	}
}
