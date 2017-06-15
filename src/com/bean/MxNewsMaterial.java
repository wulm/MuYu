package com.bean;

import java.util.Date;

/**
 * MxNewsMaterial entity. @author MyEclipse Persistence Tools
 */

public class MxNewsMaterial implements java.io.Serializable {

	// Fields

	private Integer newsMaterialId;
	private Integer materialType;
	private String loadUrl;
	private String describe;
	private Integer submitUserId;
	private Date createDate;
	private String others;

	// Constructors

	/** default constructor */
	public MxNewsMaterial() {
	}

	/** minimal constructor */
	public MxNewsMaterial(Integer newsMaterialId, Integer materialType,
			String loadUrl, String describe, Integer submitUserId,
			Date createDate) {
		this.newsMaterialId = newsMaterialId;
		this.materialType = materialType;
		this.loadUrl = loadUrl;
		this.describe = describe;
		this.submitUserId = submitUserId;
		this.createDate = createDate;
	}

	/** full constructor */
	public MxNewsMaterial(Integer newsMaterialId, Integer materialType,
			String loadUrl, String describe, Integer submitUserId,
			Date createDate, String others) {
		this.newsMaterialId = newsMaterialId;
		this.materialType = materialType;
		this.loadUrl = loadUrl;
		this.describe = describe;
		this.submitUserId = submitUserId;
		this.createDate = createDate;
		this.others = others;
	}

	// Property accessors

	public Integer getNewsMaterialId() {
		return this.newsMaterialId;
	}

	public void setNewsMaterialId(Integer newsMaterialId) {
		this.newsMaterialId = newsMaterialId;
	}

	public Integer getMaterialType() {
		return this.materialType;
	}

	public void setMaterialType(Integer materialType) {
		this.materialType = materialType;
	}

	public String getLoadUrl() {
		return this.loadUrl;
	}

	public void setLoadUrl(String loadUrl) {
		this.loadUrl = loadUrl;
	}

	public String getDescribe() {
		return this.describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public Integer getSubmitUserId() {
		return this.submitUserId;
	}

	public void setSubmitUserId(Integer submitUserId) {
		this.submitUserId = submitUserId;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getOthers() {
		return this.others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

}