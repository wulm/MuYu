package com.bean;

import java.sql.Timestamp;

/**
 * MxUsersData entity. @author MyEclipse Persistence Tools
 */

public class MxUsersData implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String userName;
	private String password;
	private Integer userTypeId;
	private String weixinOpenId;
	private String weixinNikeName;
	private String weixinHeadUrl;
	private Timestamp subscribeTime;
	private String weixinRemark;
	private Integer userSex;
	private String weixinGroupid;
	private String weixinTagidList;
	private Integer userAge;
	private Integer userSchoolId;
	private String userEmail;
	private String userPhoneNum;
	private Integer reporterTeamId;
	private String userTags;
	private Integer userState;
	private Integer userRegionId;
	private String userAddr;
	private Timestamp lastLoginTime;
	private String others;
	private String userRealName;

	// Constructors

	/** default constructor */
	public MxUsersData() {
		this.setUserId(0);
		this.setUserName("no set");
		this.setPassword("123456");
		this.setUserTypeId(-1);
		this.setWeixinOpenId("");
		this.setWeixinNikeName("");
		this.setWeixinHeadUrl("");
		this.setSubscribeTime(new Timestamp(System.currentTimeMillis()));
		this.setWeixinRemark("");
		this.setUserSex(0);
		this.setWeixinGroupid("");
		this.setWeixinTagidList("");
		this.setUserAge(0);
		this.setUserSchoolId(-1011);
		this.setUserEmail("");
		this.setUserPhoneNum("");
		this.setReporterTeamId(-1011);
		this.setUserTags("");
		this.setUserRegionId(-1011);
		this.setUserAddr("");
		this.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
		this.setOthers("");
		this.setUserState(0);
		this.setUserRealName("");
	}

	/** minimal constructor */
	public MxUsersData(Integer userId, String userName, String password,
			Integer userTypeId, String weixinOpenId, String weixinNikeName,
			String weixinHeadUrl, Timestamp subscribeTime, String weixinRemark,
			Integer userSex, String weixinGroupid, String weixinTagidList,
			Integer userAge, Integer userSchoolId, String userEmail,
			String userPhoneNum, Integer reporterTeamId, String userTags,
			Integer userState, Integer userRegionId, String userAddr,
			Timestamp lastLoginTime, String userRealName) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.userTypeId = userTypeId;
		this.weixinOpenId = weixinOpenId;
		this.weixinNikeName = weixinNikeName;
		this.weixinHeadUrl = weixinHeadUrl;
		this.subscribeTime = subscribeTime;
		this.weixinRemark = weixinRemark;
		this.userSex = userSex;
		this.weixinGroupid = weixinGroupid;
		this.weixinTagidList = weixinTagidList;
		this.userAge = userAge;
		this.userSchoolId = userSchoolId;
		this.userEmail = userEmail;
		this.userPhoneNum = userPhoneNum;
		this.reporterTeamId = reporterTeamId;
		this.userTags = userTags;
		this.userState = userState;
		this.userRegionId = userRegionId;
		this.userAddr = userAddr;
		this.lastLoginTime = lastLoginTime;
		this.userRealName = userRealName;
	}

	/** full constructor */
	public MxUsersData(Integer userId, String userName, String password,
			Integer userTypeId, String weixinOpenId, String weixinNikeName,
			String weixinHeadUrl, Timestamp subscribeTime, String weixinRemark,
			Integer userSex, String weixinGroupid, String weixinTagidList,
			Integer userAge, Integer userSchoolId, String userEmail,
			String userPhoneNum, Integer reporterTeamId, String userTags,
			Integer userState, Integer userRegionId, String userAddr,
			Timestamp lastLoginTime, String others, String userRealName) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.userTypeId = userTypeId;
		this.weixinOpenId = weixinOpenId;
		this.weixinNikeName = weixinNikeName;
		this.weixinHeadUrl = weixinHeadUrl;
		this.subscribeTime = subscribeTime;
		this.weixinRemark = weixinRemark;
		this.userSex = userSex;
		this.weixinGroupid = weixinGroupid;
		this.weixinTagidList = weixinTagidList;
		this.userAge = userAge;
		this.userSchoolId = userSchoolId;
		this.userEmail = userEmail;
		this.userPhoneNum = userPhoneNum;
		this.reporterTeamId = reporterTeamId;
		this.userTags = userTags;
		this.userState = userState;
		this.userRegionId = userRegionId;
		this.userAddr = userAddr;
		this.lastLoginTime = lastLoginTime;
		this.others = others;
		this.userRealName = userRealName;
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

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getUserTypeId() {
		return this.userTypeId;
	}

	public void setUserTypeId(Integer userTypeId) {
		this.userTypeId = userTypeId;
	}

	public String getWeixinOpenId() {
		return this.weixinOpenId;
	}

	public void setWeixinOpenId(String weixinOpenId) {
		this.weixinOpenId = weixinOpenId;
	}

	public String getWeixinNikeName() {
		return this.weixinNikeName;
	}

	public void setWeixinNikeName(String weixinNikeName) {
		this.weixinNikeName = weixinNikeName;
	}

	public String getWeixinHeadUrl() {
		return this.weixinHeadUrl;
	}

	public void setWeixinHeadUrl(String weixinHeadUrl) {
		this.weixinHeadUrl = weixinHeadUrl;
	}

	public Timestamp getSubscribeTime() {
		return this.subscribeTime;
	}

	public void setSubscribeTime(Timestamp subscribeTime) {
		this.subscribeTime = subscribeTime;
	}

	public String getWeixinRemark() {
		return this.weixinRemark;
	}

	public void setWeixinRemark(String weixinRemark) {
		this.weixinRemark = weixinRemark;
	}

	public Integer getUserSex() {
		return this.userSex;
	}

	public void setUserSex(Integer userSex) {
		this.userSex = userSex;
	}

	public String getWeixinGroupid() {
		return this.weixinGroupid;
	}

	public void setWeixinGroupid(String weixinGroupid) {
		this.weixinGroupid = weixinGroupid;
	}

	public String getWeixinTagidList() {
		return this.weixinTagidList;
	}

	public void setWeixinTagidList(String weixinTagidList) {
		this.weixinTagidList = weixinTagidList;
	}

	public Integer getUserAge() {
		return this.userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	public Integer getUserSchoolId() {
		return this.userSchoolId;
	}

	public void setUserSchoolId(Integer userSchoolId) {
		this.userSchoolId = userSchoolId;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhoneNum() {
		return this.userPhoneNum;
	}

	public void setUserPhoneNum(String userPhoneNum) {
		this.userPhoneNum = userPhoneNum;
	}

	public Integer getReporterTeamId() {
		return this.reporterTeamId;
	}

	public void setReporterTeamId(Integer reporterTeamId) {
		this.reporterTeamId = reporterTeamId;
	}

	public String getUserTags() {
		return this.userTags;
	}

	public void setUserTags(String userTags) {
		this.userTags = userTags;
	}

	public Integer getUserState() {
		return this.userState;
	}

	public void setUserState(Integer userState) {
		this.userState = userState;
	}

	public Integer getUserRegionId() {
		return this.userRegionId;
	}

	public void setUserRegionId(Integer userRegionId) {
		this.userRegionId = userRegionId;
	}

	public String getUserAddr() {
		return this.userAddr;
	}

	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}

	public Timestamp getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getOthers() {
		return this.others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	public String getUserRealName() {
		return this.userRealName;
	}

	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}

}