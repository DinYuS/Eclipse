package org.ali.bank.vo;

public class User {
	private String Uid;
	private String Uname;
	
	
	/**
	 * @param uid 用户身份证号码
	 * @param uname 用户姓名
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
	
