package com.bean;

import java.util.Date;

/**
 * MxNewsType entity. @author MyEclipse Persistence Tools
 */

public class MxNewsType implements java.io.Serializable {

	// Fields

	private Integer newsTypeId;
	private String typeName;
	private Integer parentId;
	private String describe;
	private Date createDate;
	private Date updateDate;
	private String others;

	// Constructors

	/** default constructor */
	public MxNewsType() {
	}

	/** minimal constructor */
	public MxNewsType(Integer newsTypeId, String typeName, Integer parentId,
			String describe, Date createDate, Date updateDate) {
		this.newsTypeId = newsTypeId;
		this.typeName = typeName;
		this.parentId = parentId;
		this.describe = describe;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	/** full constructor */
	public MxNewsType(Integer newsTypeId, String typeName, Integer parentId,
			String describe, Date createDate, Date updateDate, String others) {
		this.newsTypeId = newsTypeId;
		this.typeName = typeName;
		this.parentId = parentId;
		this.describe = describe;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.others = others;
	}

	// Property accessors

	public Integer getNewsTypeId() {
		return this.newsTypeId;
	}

	public void setNewsTypeId(Integer newsTypeId) {
		this.newsTypeId = newsTypeId;
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

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getOthers() {
		return this.others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

}