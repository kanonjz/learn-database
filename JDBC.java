//version1.0 
//使用Statement
package com.netease.course;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloJDBC {
	
	static final String JDBC_DRIVER = "org.postgresql.Driver";
	static final String DB_URL = "jdbc:postgresql://localhost:5432/testjdbc";
	static final String USER = "postgres";
	static final String PASSWORD = "123456";
	
	public static void helloword() throws ClassNotFoundException{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
                // 1.装载驱动程序
		Class.forName(JDBC_DRIVER);
		// 2.建立数据库连接
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			// 3.执行SQL语句
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from info");
			// 4.获取执行结果
			while(rs.next()) {
				System.out.println("Hello "+rs.getString("firstname"));
			}
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

/********************************************************************************************/
//version2.0
//使用PreparedStatement

package com.netease.course;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HelloJDBC {
	
	static final String JDBC_DRIVER = "org.postgresql.Driver";
	static String DB_URL = "jdbc:postgresql://localhost:5432/testjdbc";
	static final String USER = "postgres";
	static final String PASSWORD = "123456";
	
	public static void helloword() throws ClassNotFoundException{		
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		DB_URL = DB_URL + "?useCursorFetch=true";
		
                // 1.装载驱动程序
		Class.forName(JDBC_DRIVER);
		// 2.建立数据库连接
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			// 3.执行SQL语句
			ptmt = conn.prepareStatement("select * from info");
			rs = ptmt.executeQuery();
			// 4.获取执行结果
			while(rs.next()) {
				System.out.println("Hello "+rs.getString("firstname"));
			}
		} catch(SQLException e) {
			// 异常处理
			e.printStackTrace();
		} finally {
			// 5.清理环境(很重要）
			try {
			if(conn != null)
				conn.close();
			if(ptmt != null)
				ptmt.close();
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

