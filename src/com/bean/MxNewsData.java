package com.bean;

import java.sql.Timestamp;
import java.util.Date;

/**
 * MxNewsData entity. @author MyEclipse Persistence Tools
 */

public class MxNewsData implements java.io.Serializable {

	// Fields

	private Integer newsId;
	private Integer newsWriterId;
	private String writerName;
	private String newsHeadline;
	private String newsLeadText;
	private String newsMainContent;
	private Integer commentNum;
	private Integer praiseClickNum;
	private Date createDate;
	private Date updateDate;
	private String others;
	private Integer newsTypeId;
	private Integer regionId;
	private Integer schoolId;
	private Integer state;

	// Constructors

	/** default constructor */
	public MxNewsData() {
		this.setNewsId(0);
		this.setNewsWriterId(-1);
		this.setWriterName("no set");
		this.setNewsHeadline("no set");
		this.setNewsLeadText("no set");
		this.setNewsMainContent("no set");
		this.setCommentNum(-1);
		this.setPraiseClickNum(-1);
		this.setCreateDate(new Timestamp(System.currentTimeMillis()));
		this.setUpdateDate(new Timestamp(System.currentTimeMillis()));
		this.setOthers("no set");
		this.setNewsTypeId(-1);
		this.setRegionId(-1);
		this.setSchoolId(-1);
		this.setState(0);
	}

	@Override
	public String toString() {
		return "MxNewsData [newsId=" + newsId + ", newsWriterId="
				+ newsWriterId + ", writerName=" + writerName
				+ ", newsHeadline=" + newsHeadline + ", newsLeadText="
				+ newsLeadText + ", newsMainContent=" + newsMainContent
				+ ", commentNum=" + commentNum + ", praiseClickNum="
				+ praiseClickNum + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + ", others=" + others
				+ ", newsTypeId=" + newsTypeId + ", regionId=" + regionId
				+ ", schoolId=" + schoolId + ", state=" + state + "]";
	}

	/** minimal constructor */
	public MxNewsData(Integer newsId, Integer newsWriterId, String writerName,
			String newsHeadline, String newsLeadText, String newsMainContent,
			Integer commentNum, Integer praiseClickNum, Date createDate,
			Date updateDate, Integer newsTypeId, Integer regionId,
			Integer schoolId, Integer state) {
		this.newsId = newsId;
		this.newsWriterId = newsWriterId;
		this.writerName = writerName;
		this.newsHeadline = newsHeadline;
		this.newsLeadText = newsLeadText;
		this.newsMainContent = newsMainContent;
		this.commentNum = commentNum;
		this.praiseClickNum = praiseClickNum;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.newsTypeId = newsTypeId;
		this.regionId = regionId;
		this.schoolId = schoolId;
		this.state = state;
	}

	/** full constructor */
	public MxNewsData(Integer newsId, Integer newsWriterId, String writerName,
			String newsHeadline, String newsLeadText, String newsMainContent,
			Integer commentNum, Integer praiseClickNum, Date createDate,
			Date updateDate, String others, Integer newsTypeId,
			Integer regionId, Integer schoolId, Integer state) {
		this.newsId = newsId;
		this.newsWriterId = newsWriterId;
		this.writerName = writerName;
		this.newsHeadline = newsHeadline;
		this.newsLeadText = newsLeadText;
		this.newsMainContent = newsMainContent;
		this.commentNum = commentNum;
		this.praiseClickNum = praiseClickNum;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.others = others;
		this.newsTypeId = newsTypeId;
		this.regionId = regionId;
		this.schoolId = schoolId;
		this.state = state;
	}

	// Property accessors

	public Integer getNewsId() {
		return this.newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	public Integer getNewsWriterId() {
		return this.newsWriterId;
	}

	public void setNewsWriterId(Integer newsWriterId) {
		this.newsWriterId = newsWriterId;
	}

	public String getWriterName() {
		return this.writerName;
	}

	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}

	public String getNewsHeadline() {
		return this.newsHeadline;
	}

	public void setNewsHeadline(String newsHeadline) {
		this.newsHeadline = newsHeadline;
	}

	public String getNewsLeadText() {
		return this.newsLeadText;
	}

	public void setNewsLeadText(String newsLeadText) {
		this.newsLeadText = newsLeadText;
	}

	public String getNewsMainContent() {
		return this.newsMainContent;
	}

	public void setNewsMainContent(String newsMainContent) {
		this.newsMainContent = newsMainContent;
	}

	public Integer getCommentNum() {
		return this.commentNum;
	}

	public void setCommentNum(Integer commentNum) {
		this.commentNum = commentNum;
	}

	public Integer getPraiseClickNum() {
		return this.praiseClickNum;
	}

	public void setPraiseClickNum(Integer praiseClickNum) {
		this.praiseClickNum = praiseClickNum;
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

	public Integer getNewsTypeId() {
		return this.newsTypeId;
	}

	public void setNewsTypeId(Integer newsTypeId) {
		this.newsTypeId = newsTypeId;
	}

	public Integer getRegionId() {
		return this.regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public Integer getSchoolId() {
		return this.schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}