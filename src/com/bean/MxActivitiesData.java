package com.bean;

import java.sql.Timestamp;

/**
 * MxActivitiesData entity. @author MyEclipse Persistence Tools
 */

public class MxActivitiesData implements java.io.Serializable {

	// Fields

	private Integer activitiesId;
	private Integer releaseUserId;
	private String activitiesName;
	private Integer activitiesTypeId;
	private String activitiesDescribe;
	private Integer state;
	private Timestamp createDate;
	private Timestamp updateDate;
	private String others;
	private Integer upperLimit;
	private Integer lowerLimit;

	// Constructors

	/** default constructor */
	public MxActivitiesData() {
		this.setActivitiesId(-1);
		this.setReleaseUserId(-1011);
		this.setActivitiesName("no set");
		this.setActivitiesTypeId(-1011);
		this.setActivitiesDescribe("no set");
		this.setState(-1011);
		this.setCreateDate(new Timestamp(System.currentTimeMillis()));
		this.setUpdateDate(new Timestamp(System.currentTimeMillis()));
		this.setOthers("no set");
		this.setUpperLimit(-1011);
		this.setLowerLimit(-1011);
	}

	/** minimal constructor */
	public MxActivitiesData(Integer activitiesId, Integer releaseUserId,
			String activitiesName, Integer activitiesTypeId,
			String activitiesDescribe, Integer state, Timestamp createDate,
			Timestamp updateDate, Integer upperLimit, Integer lowerLimit) {
		this.activitiesId = activitiesId;
		this.releaseUserId = releaseUserId;
		this.activitiesName = activitiesName;
		this.activitiesTypeId = activitiesTypeId;
		this.activitiesDescribe = activitiesDescribe;
		this.state = state;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.upperLimit = upperLimit;
		this.lowerLimit = lowerLimit;
	}

	/** full constructor */
	public MxActivitiesData(Integer activitiesId, Integer releaseUserId,
			String activitiesName, Integer activitiesTypeId,
			String activitiesDescribe, Integer state, Timestamp createDate,
			Timestamp updateDate, String others, Integer upperLimit,
			Integer lowerLimit) {
		this.activitiesId = activitiesId;
		this.releaseUserId = releaseUserId;
		this.activitiesName = activitiesName;
		this.activitiesTypeId = activitiesTypeId;
		this.activitiesDescribe = activitiesDescribe;
		this.state = state;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.others = others;
		this.upperLimit = upperLimit;
		this.lowerLimit = lowerLimit;
	}

	// Property accessors

	public Integer getActivitiesId() {
		return this.activitiesId;
	}

	public void setActivitiesId(Integer activitiesId) {
		this.activitiesId = activitiesId;
	}

	public Integer getReleaseUserId() {
		return this.releaseUserId;
	}

	public void setReleaseUserId(Integer releaseUserId) {
		this.releaseUserId = releaseUserId;
	}

	public String getActivitiesName() {
		return this.activitiesName;
	}

	public void setActivitiesName(String activitiesName) {
		this.activitiesName = activitiesName;
	}

	public Integer getActivitiesTypeId() {
		return this.activitiesTypeId;
	}

	public void setActivitiesTypeId(Integer activitiesTypeId) {
		this.activitiesTypeId = activitiesTypeId;
	}

	public String getActivitiesDescribe() {
		return this.activitiesDescribe;
	}

	public void setActivitiesDescribe(String activitiesDescribe) {
		this.activitiesDescribe = activitiesDescribe;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
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

	public Integer getUpperLimit() {
		return this.upperLimit;
	}

	public void setUpperLimit(Integer upperLimit) {
		this.upperLimit = upperLimit;
	}

	public Integer getLowerLimit() {
		return this.lowerLimit;
	}

	public void setLowerLimit(Integer lowerLimit) {
		this.lowerLimit = lowerLimit;
	}

}