package org.ali.bank.common;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.ali.bank.vo.User;





public class DateBaseOperate {
	
	/**
	 * @param Uid �û����֤����
	 * @return
	 */
	public User queryUidFromUser(String Uid) {
		User user = new User();
		ResultSet rs = null;
		Connection conn = null;
		Statement st = null;

		try {
			String sql = "SELECT * FROM  users WHERE Uid=" + user;
			conn = new DataBaseConnection().getConnection();
			st=conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				user.setUid(rs.getString("Uid"));
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

		return user;

	}
}
