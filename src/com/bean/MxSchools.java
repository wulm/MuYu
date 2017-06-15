package com.bean;

import java.util.Date;

/**
 * MxSchools entity. @author MyEclipse Persistence Tools
 */

public class MxSchools implements java.io.Serializable {

	// Fields

	private Integer schoolId;
	private String schoolName;
	private Integer schoolRegionId;
	private String schoolAddress;
	private Date createDate;
	private Date updateDate;
	private String others;

	// Constructors

	/** default constructor */
	public MxSchools() {
	}

	/** minimal constructor */
	public MxSchools(Integer schoolId, String schoolName,
			Integer schoolRegionId, String schoolAddress, Date createDate,
			Date updateDate) {
		this.schoolId = schoolId;
		this.schoolName = schoolName;
		this.schoolRegionId = schoolRegionId;
		this.schoolAddress = schoolAddress;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	/** full constructor */
	public MxSchools(Integer schoolId, String schoolName,
			Integer schoolRegionId, String schoolAddress, Date createDate,
			Date updateDate, String others) {
		this.schoolId = schoolId;
		this.schoolName = schoolName;
		this.schoolRegionId = schoolRegionId;
		this.schoolAddress = schoolAddress;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.others = others;
	}

	// Property accessors

	public Integer getSchoolId() {
		return this.schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	public String getSchoolName() {
		return this.schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public Integer getSchoolRegionId() {
		return this.schoolRegionId;
	}

	public void setSchoolRegionId(Integer schoolRegionId) {
		this.schoolRegionId = schoolRegionId;
	}

	public String getSchoolAddress() {
		return this.schoolAddress;
	}

	public void setSchoolAddress(String schoolAddress) {
		this.schoolAddress = schoolAddress;
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