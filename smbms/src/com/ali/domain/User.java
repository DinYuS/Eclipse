package com.ali.domain;

import java.util.Date;

public class User {
	private long id;
	private String contact;
	private String addressDesc;
	private String postCode;
	private String tel;
	private long createBy;
	private Date crearionDate;
	private long modifyBy;
	private Date modifyDate;
	private long userId;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(long id, String contact, String addressDesc, String postCode, String tel, long createBy,
			Date crearionDate, long modifyBy, Date modifyDate, long userId) {
		super();
		this.id = id;
		this.contact = contact;
		this.addressDesc = addressDesc;
		this.postCode = postCode;
		this.tel = tel;
		this.createBy = createBy;
		this.crearionDate = crearionDate;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
		this.userId = userId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddressDesc() {
		return addressDesc;
	}

	public void setAddressDesc(String addressDesc) {
		this.addressDesc = addressDesc;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(long createBy) {
		this.createBy = createBy;
	}

	public Date getCrearionDate() {
		return crearionDate;
	}

	public void setCrearionDate(Date crearionDate) {
		this.crearionDate = crearionDate;
	}

	public long getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(long modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", contact=" + contact + ", addressDesc=" + addressDesc + ", postCode=" + postCode
				+ ", tel=" + tel + ", createBy=" + createBy + ", crearionDate=" + crearionDate + ", modifyBy="
				+ modifyBy + ", modifyDate=" + modifyDate + ", userId=" + userId + "]";
	}
	
}
