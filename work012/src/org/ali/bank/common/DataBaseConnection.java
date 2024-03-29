package org.ali.bank.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnection {
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://root@localhost/bank?serverTimezone=GMT%2B8";
	private static String user = "root";
	private static String password = "123456";

	static {
		// 注册 JDBC 驱动
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 连接数据库
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	public static void closeAll(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
		// 完成后关闭
		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (conn != null) {
			conn.close();
		}
	}

}
