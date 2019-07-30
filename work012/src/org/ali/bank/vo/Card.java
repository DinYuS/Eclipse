package org.ali.bank.vo;

public class Card {
	private String Cid;
	private String Cuse;
	private String Conline;
	private String C_Uid;
	private String C_Upassword;
	private double Cmoney;
	/**
	 * @param Cid 卡号
	 * @param Cuse 使用状态
	 * @param Conline 网银开通状态
	 * @param Cmoney 网银开通状态
	 * @param C_Uid 用户id
	 * @param C_Upassword 用户密码
	 */
	
	public Card() {
		super();
		this.Cid = "";
		this.Cuse = "";
		this.Conline = "";
		this.Cmoney = 0.0;
		this.C_Uid = "";
		this.C_Upassword = "";
	}
	
//	public Card(String cid, String cuse, String conline, String uid, String upassword) {
//		super();
//		Cid = cid;
//		Cuse = cuse;
//		Conline = conline;
//		C_Uid = uid;
//		C_Upassword = upassword;
//	}


	
	public String getCid() {
		return Cid;
	}


	
	public void setCid(String cid) {
		Cid = cid;
	}


	
	public String getCuse() {
		return Cuse;
	}


	
	public void setCuse(String cuse) {
		Cuse = cuse;
	}


	
	public String getConline() {
		return Conline;
	}


	
	public void setConline(String conline) {
		Conline = conline;
	}


	
	public double getCmoney() {
		return Cmoney;
	}

	public void setCmoney(double cmoney) {
		Cmoney = cmoney;
	}

	public String getUid() {
		return C_Uid;
	}
	
	
	
	public void setUid(String uid) {
		C_Uid = uid;
	}


	
	public String getUpassword() {
		return C_Upassword;
	}


	
	public void setUpassword(String upassword) {
		C_Upassword = upassword;
	}
}
