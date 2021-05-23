package com.chinasofti.entity;
/**
 * 
 * @author 林镕琛
 * @version 1.0
 * 用户User这个实体类
 */
public class User {
	private String uid;
	private String userName = null ;
	private String pwd = null;
	String role;
	
	public User() {
		super();
	}
	
	public User(String uid, String userName, String pwd,String role) {
		super();
		this.userName = userName;
		this.pwd = pwd;
		this.role = role;
		this.uid = uid;
	}
	
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.role = uid;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
