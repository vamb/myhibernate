package com.pear.zcp.entity;

import java.util.Date;

public class User {
	
	private String id;
	private String name;
	private byte gender;
	private Date birthday;
	
	@SuppressWarnings("unused")
	private User() {
		// this form used by Hibernate.
	}
	
	public User(String name, byte gender, Date birthday) {
		// for application use , create new use.
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getGender() {
		return gender;
	}

	public void setGender(byte gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
