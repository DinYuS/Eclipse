package org.ali.bank.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.ali.bank.common.DataBaseConnection;

public class DateToString {
	
	/**
	 * 数据库sql语句操作的执行，可用于数据的查询和更新
	 * @param sql
	 * @return
	 */
	public static int dataBaseUpdate(String sql){
		Connection conn = null;
		Statement st =null;
		int result;
		try {
			conn = new DataBaseConnection().getConnection();
			st=conn.createStatement();
			result = st.executeUpdate(sql);
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				st.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
}
