package com.bean;

/**
 * MyUsers entity. @author MyEclipse Persistence Tools
 */

public class MyUsers implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String userName;
	private String userPwd;
	private Integer userType;
	private Integer state;

	// Constructors

	/** default constructor */
	public MyUsers() {
	}

	/** minimal constructor */
	public MyUsers(Integer userId, Integer userType, Integer state) {
		this.userId = userId;
		this.userType = userType;
		this.state = state;
	}

	/** full constructor */
	public MyUsers(Integer userId, String userName, String userPwd,
			Integer userType, Integer state) {
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userType = userType;
		this.state = state;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return this.userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public Integer getUserType() {
		return this.userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}