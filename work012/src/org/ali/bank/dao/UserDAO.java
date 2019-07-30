package org.ali.bank.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.ali.bank.common.DataBaseConnection;
import org.ali.bank.vo.User;

public class UserDAO {

	/**
	 * ����������֤�Ž����������������֤������
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
			// TODO �Զ����ɵ� catch ��
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
		//System.out.println("��ӭ��ʹ�����й�Աϵͳ------------"+user.getUid()+user.getUname());
		return user;
	}

	/**
	 * ������������֤���ж��û��Ƿ�Ϸ�
	 * 
	 * @param uid ���֤��
	 * @return
	 */
	public boolean verifyUserFromUser(String uid) {
		User user = new User();
		user = new UserDAO().queryUserFromUser(uid);
		if (user.getUid().equals("")) {
			return false;
		} else {
			System.out.println("----------------------------------\n");
			System.out.println("��֤�ɹ�����ӭ��!  ");
			System.out.println("�𾴵��û�  " + user.getUname() + "\n");
			System.out.println("----------------------------------\n");
			return true;
		}
	}

	/**
	 * �������֤���ж��������û��
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
//				// TODO �Զ����ɵ� catch ��
//				e.printStackTrace();
//			}
	//
//			return user;
	//
//		}

}
