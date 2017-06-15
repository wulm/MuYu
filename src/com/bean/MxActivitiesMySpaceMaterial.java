package com.bean;

import java.sql.Timestamp;

/**
 * MxActivitiesMySpaceMaterial entity. @author MyEclipse Persistence Tools
 */

public class MxActivitiesMySpaceMaterial implements java.io.Serializable {

	// Fields

	private Integer materialId;
	private Integer activitiesId;
	private Integer myspaceId;
	private Integer materialType;
	private String loadUrl;
	private String describe;
	private Timestamp createDate;
	private String others;

	// Constructors

	/** default constructor */
	public MxActivitiesMySpaceMaterial() {
	}

	/** minimal constructor */
	public MxActivitiesMySpaceMaterial(Integer materialId,
			Integer activitiesId, Integer myspaceId, Integer materialType,
			String loadUrl, String describe, Timestamp createDate) {
		this.materialId = materialId;
		this.activitiesId = activitiesId;
		this.myspaceId = myspaceId;
		this.materialType = materialType;
		this.loadUrl = loadUrl;
		this.describe = describe;
		this.createDate = createDate;
	}

	/** full constructor */
	public MxActivitiesMySpaceMaterial(Integer materialId,
			Integer activitiesId, Integer myspaceId, Integer materialType,
			String loadUrl, String describe, Timestamp createDate, String others) {
		this.materialId = materialId;
		this.activitiesId = activitiesId;
		this.myspaceId = myspaceId;
		this.materialType = materialType;
		this.loadUrl = loadUrl;
		this.describe = describe;
		this.createDate = createDate;
		this.others = others;
	}

	// Property accessors

	public Integer getMaterialId() {
		return this.materialId;
	}

	public void setMaterialId(Integer materialId) {
		this.materialId = materialId;
	}

	public Integer getActivitiesId() {
		return this.activitiesId;
	}

	public void setActivitiesId(Integer activitiesId) {
		this.activitiesId = activitiesId;
	}

	public Integer getMyspaceId() {
		return this.myspaceId;
	}

	public void setMyspaceId(Integer myspaceId) {
		this.myspaceId = myspaceId;
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

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getOthers() {
		return this.others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

}