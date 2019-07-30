package org.ali.bank.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.ali.bank.common.DataBaseConnection;
import org.ali.bank.vo.Admin;

public class AdminDAO {
	Scanner scanner = new Scanner(System.in);
	
	public String inputString() {

		return scanner.next();
	}

	/**
	 * 
	 * @param aid 柜员账户
	 * @param password 柜员密码
	 * @return
	 */
	@SuppressWarnings("static-access")
	public Admin queryAdminFromAdmin(String aid) {
		Admin admin = new Admin();
		ResultSet rs = null;
		Connection conn = null;
		Statement st = null;
		String sql = "SELECT Aid,Apassword FROM admin WHERE Aid='" + aid + "'";

		try {
			conn = new DataBaseConnection().getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				admin.setId(rs.getString("Aid"));
				admin.setPassword(rs.getString("Apassword"));
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
		//System.out.println(admin.getId()+"    "+admin.getPassword());
		return admin;
	}
	
	
	
	
	public boolean verifyAdminFromAdmin(String aid,String password) {
		Admin admin = new Admin();
		String aid1 = this.inputString();
		String password1 = this.inputString();
		admin = new AdminDAO().queryAdminFromAdmin(aid);
		if (admin.getPassword()!=password1) {
			
			return true;
		} else {
			
			return false;
		}
	}
}
