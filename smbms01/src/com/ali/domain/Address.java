package com.ali.domain;

import java.util.Date;

import javax.print.attribute.standard.DateTimeAtCompleted;

public class Address {
	private int id;
	private String contact;
	private String addressDesc;
	private String postCode;
	private String tel;
	private int createdBy;
	private Date crearionDate;
	private int modifyBy;
	private Date modifyDate;
	private int userId;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(int id, String contact, String addressDesc, String postCode, String tel, long createBy,
			Date crearionDate, int modifyBy, Date modifyDate, int userId, int createdBy) {
		super();
		this.id = id;
		this.contact = contact;
		this.addressDesc = addressDesc;
		this.postCode = postCode;
		this.tel = tel;
		this.createdBy = createdBy;
		this.crearionDate = crearionDate;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
		this.userId = userId;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
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

	public long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
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

	public void setModifyBy(int modifyBy) {
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

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
