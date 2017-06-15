package com.bean;

import java.sql.Timestamp;

/**
 * MxActivitiesPublicityMaterial entity. @author MyEclipse Persistence Tools
 */

public class MxActivitiesPublicityMaterial implements java.io.Serializable {

	// Fields

	private Integer publicityMaterialId;
	private Integer publicityDataId;
	private Integer materialType;
	private String loadUrl;
	private String describe;
	private Timestamp createDate;
	private String others;

	// Constructors

	/** default constructor */
	public MxActivitiesPublicityMaterial() {
	}

	/** minimal constructor */
	public MxActivitiesPublicityMaterial(Integer publicityMaterialId,
			Integer publicityDataId, Integer materialType, String loadUrl,
			String describe, Timestamp createDate) {
		this.publicityMaterialId = publicityMaterialId;
		this.publicityDataId = publicityDataId;
		this.materialType = materialType;
		this.loadUrl = loadUrl;
		this.describe = describe;
		this.createDate = createDate;
	}

	/** full constructor */
	public MxActivitiesPublicityMaterial(Integer publicityMaterialId,
			Integer publicityDataId, Integer materialType, String loadUrl,
			String describe, Timestamp createDate, String others) {
		this.publicityMaterialId = publicityMaterialId;
		this.publicityDataId = publicityDataId;
		this.materialType = materialType;
		this.loadUrl = loadUrl;
		this.describe = describe;
		this.createDate = createDate;
		this.others = others;
	}

	// Property accessors

	public Integer getPublicityMaterialId() {
		return this.publicityMaterialId;
	}

	public void setPublicityMaterialId(Integer publicityMaterialId) {
		this.publicityMaterialId = publicityMaterialId;
	}

	public Integer getPublicityDataId() {
		return this.publicityDataId;
	}

	public void setPublicityDataId(Integer publicityDataId) {
		this.publicityDataId = publicityDataId;
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