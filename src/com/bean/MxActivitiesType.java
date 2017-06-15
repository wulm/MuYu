package com.bean;

import java.sql.Timestamp;

/**
 * MxActivitiesType entity. @author MyEclipse Persistence Tools
 */

public class MxActivitiesType implements java.io.Serializable {

	// Fields

	private Integer activitiesTypeId;
	private String typeName;
	private Integer parentId;
	private String describe;
	private Timestamp createDate;
	private Timestamp updateDate;
	private String others;

	// Constructors

	/** default constructor */
	public MxActivitiesType() {
	}

	/** minimal constructor */
	public MxActivitiesType(Integer activitiesTypeId, String typeName,
			Integer parentId, String describe, Timestamp createDate,
			Timestamp updateDate) {
		this.activitiesTypeId = activitiesTypeId;
		this.typeName = typeName;
		this.parentId = parentId;
		this.describe = describe;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	/** full constructor */
	public MxActivitiesType(Integer activitiesTypeId, String typeName,
			Integer parentId, String describe, Timestamp createDate,
			Timestamp updateDate, String others) {
		this.activitiesTypeId = activitiesTypeId;
		this.typeName = typeName;
		this.parentId = parentId;
		this.describe = describe;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.others = others;
	}

	// Property accessors

	public Integer getActivitiesTypeId() {
		return this.activitiesTypeId;
	}

	public void setActivitiesTypeId(Integer activitiesTypeId) {
		this.activitiesTypeId = activitiesTypeId;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getDescribe() {
		return this.describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
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