package org.ali.bank.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.ali.bank.common.DataBaseConnection;
import org.ali.bank.vo.User;

public class UserDAO {

	/**
	 * 对输入的身份证号进行搜索，返回身份证及姓名
	 * 
	 * @param uid
	 * @return
	 */
	@SuppressWarnings("static-access")
	public User queryUserFromUser(String uid) {
		User user = new User();
		ResultSet rs = null;
		Connection conn = null;
		Statement st = null;
		String sql = "SELECT Uid,Uname FROM  users WHERE Uid='" + uid + "'";

		try {
			conn = new DataBaseConnection().getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				user.setUid(rs.getString("Uid"));
				user.setUname(rs.getString("Uname"));
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			try {
				//DataBaseConnection.closeAll(conn, st, rs);
				rs.close();
				st.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		//System.out.println("欢迎您使用银行柜员系统------------"+user.getUid()+user.getUname());
		return user;
	}

	/**
	 * 根据输入的身份证号判定用户是否合法
	 * 
	 * @param uid 身份证号
	 * @return
	 */
	public boolean verifyUserFromUser(String uid) {
		User user = new User();
		user = new UserDAO().queryUserFromUser(uid);
		if (user.getUid().equals("")) {
			return false;
		} else {
			System.out.println("----------------------------------\n");
			System.out.println("认证成功！欢迎您!  ");
			System.out.println("尊敬的用户  " + user.getUname() + "\n");
			System.out.println("----------------------------------\n");
			return true;
		}
	}

	/**
	 * 根据身份证，判断这个人有没有
	 * 
	 * @param idNum
	 * @return
	 */
//		public boolean queryUidFromUser(String Uid) {
//			User user = new User();
//			ResultSet rs = null;
//			Connection conn = null;
//			Statement st = null;
	//
//			try {
//				String sql = "SELECT * FROM  users WHERE Uid=" + user;
//				conn = new DataBaseConnection().getConnection();
//				st=conn.createStatement();
//				rs = st.executeQuery(sql);
//				if (rs.next()) {
//					user.setUid(rs.getString("Uid"));
//				}
//			} catch (SQLException e) {
//				// TODO 自动生成的 catch 块
//				e.printStackTrace();
//			}
	//
//			return user;
	//
//		}

}
