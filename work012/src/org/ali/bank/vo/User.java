package org.ali.bank.vo;

public class User {
	private String Uid;
	private String Uname;
	
	
	/**
	 * @param uid �û����֤����
	 * @param uname �û�����
	 */
	
	public User() {
		super();
		this.Uid = "";
		this.Uname = "";
	}
	
//	public User(String uid, String uname) {
//		super();
//		Uid = uid;
//		Uname = uname;
//	}


	public String getUid() {
		return Uid;
	}


	public void setUid(String uid) {
		this.Uid = uid;
	}


	public String getUname() {
		return Uname;
	}


	public void setUname(String uname) {
		this.Uname = uname;
	}
	
}
	
