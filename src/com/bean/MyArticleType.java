package com.bean;

import java.sql.Timestamp;

/**
 * MyArticleType entity. @author MyEclipse Persistence Tools
 */

public class MyArticleType implements java.io.Serializable {

	// Fields

	private Integer typeId;
	private String typeName;
	private Integer parentId;
	private Timestamp createDate;
	private Timestamp updateDate;
	private String others;

	// Constructors

	/** default constructor */
	public MyArticleType() {
	}

	/** minimal constructor */
	public MyArticleType(Integer typeId, String typeName, Integer parentId,
			Timestamp createDate, Timestamp updateDate) {
		this.typeId = typeId;
		this.typeName = typeName;
		this.parentId = parentId;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	/** full constructor */
	public MyArticleType(Integer typeId, String typeName, Integer parentId,
			Timestamp createDate, Timestamp updateDate, String others) {
		this.typeId = typeId;
		this.typeName = typeName;
		this.parentId = parentId;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.others = others;
	}

	// Property accessors

	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
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