package org.ali.bank.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.ali.bank.common.DataBaseConnection;

public class DateToString {
	
	/**
	 * ���ݿ�sql��������ִ�У����������ݵĲ�ѯ�͸���
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
