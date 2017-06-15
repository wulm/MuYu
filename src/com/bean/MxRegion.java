package com.bean;

import java.util.Date;

/**
 * MxRegion entity. @author MyEclipse Persistence Tools
 */

public class MxRegion implements java.io.Serializable {

	// Fields

	private Integer regionId;
	private String regionName;
	private Integer regionParentId;
	private String regionZipCode;
	private String regionDescribe;
	private Date createDate;
	private Date updateDate;
	private String others;

	// Constructors

	/** default constructor */
	public MxRegion() {
	}

	/** minimal constructor */
	public MxRegion(Integer regionId, String regionName,
			Integer regionParentId, String regionZipCode,
			String regionDescribe, Date createDate, Date updateDate) {
		this.regionId = regionId;
		this.regionName = regionName;
		this.regionParentId = regionParentId;
		this.regionZipCode = regionZipCode;
		this.regionDescribe = regionDescribe;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	/** full constructor */
	public MxRegion(Integer regionId, String regionName,
			Integer regionParentId, String regionZipCode,
			String regionDescribe, Date createDate, Date updateDate,
			String others) {
		this.regionId = regionId;
		this.regionName = regionName;
		this.regionParentId = regionParentId;
		this.regionZipCode = regionZipCode;
		this.regionDescribe = regionDescribe;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.others = others;
	}

	// Property accessors

	public Integer getRegionId() {
		return this.regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return this.regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public Integer getRegionParentId() {
		return this.regionParentId;
	}

	public void setRegionParentId(Integer regionParentId) {
		this.regionParentId = regionParentId;
	}

	public String getRegionZipCode() {
		return this.regionZipCode;
	}

	public void setRegionZipCode(String regionZipCode) {
		this.regionZipCode = regionZipCode;
	}

	public String getRegionDescribe() {
		return this.regionDescribe;
	}

	public void setRegionDescribe(String regionDescribe) {
		this.regionDescribe = regionDescribe;
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