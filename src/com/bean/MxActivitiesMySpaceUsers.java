package com.bean;

import java.sql.Timestamp;

/**
 * MxActivitiesMySpaceUsers entity. @author MyEclipse Persistence Tools
 */

public class MxActivitiesMySpaceUsers implements java.io.Serializable {

	// Fields

	private Integer myspaceId;
	private Integer userId;
	private Timestamp createDate;
	private Timestamp updateDate;
	private String others;

	// Constructors

	/** default constructor */
	public MxActivitiesMySpaceUsers() {
	}

	/** minimal constructor */
	public MxActivitiesMySpaceUsers(Integer myspaceId, Integer userId,
			Timestamp createDate, Timestamp updateDate) {
		this.myspaceId = myspaceId;
		this.userId = userId;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	/** full constructor */
	public MxActivitiesMySpaceUsers(Integer myspaceId, Integer userId,
			Timestamp createDate, Timestamp updateDate, String others) {
		this.myspaceId = myspaceId;
		this.userId = userId;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.others = others;
	}

	// Property accessors

	public Integer getMyspaceId() {
		return this.myspaceId;
	}

	public void setMyspaceId(Integer myspaceId) {
		this.myspaceId = myspaceId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public String getOthers() {
		return this.others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

}