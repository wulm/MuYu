package com.bean;

import java.sql.Timestamp;

/**
 * MxActivitiesPublicityData entity. @author MyEclipse Persistence Tools
 */

public class MxActivitiesPublicityData implements java.io.Serializable {

	// Fields

	private Integer publicityDataId;
	private Integer authorId;
	private Integer commentNum;
	private Integer praiseClickNum;
	private Integer state;
	private Timestamp createDate;
	private String others;
	private Integer actvitiesTypeId;
	private String authorName;
	private String coverImageUrl;
	private String articleTitle;
	private String articleAbstract;

	// Constructors

	/** default constructor */
	public MxActivitiesPublicityData() {
	}

	/** minimal constructor */
	public MxActivitiesPublicityData(Integer publicityDataId, Integer authorId,
			Integer commentNum, Integer praiseClickNum, Integer state,
			Timestamp createDate, Integer actvitiesTypeId, String authorName,
			String coverImageUrl, String articleTitle, String articleAbstract) {
		this.publicityDataId = publicityDataId;
		this.authorId = authorId;
		this.commentNum = commentNum;
		this.praiseClickNum = praiseClickNum;
		this.state = state;
		this.createDate = createDate;
		this.actvitiesTypeId = actvitiesTypeId;
		this.authorName = authorName;
		this.coverImageUrl = coverImageUrl;
		this.articleTitle = articleTitle;
		this.articleAbstract = articleAbstract;
	}

	/** full constructor */
	public MxActivitiesPublicityData(Integer publicityDataId, Integer authorId,
			Integer commentNum, Integer praiseClickNum, Integer state,
			Timestamp createDate, String others, Integer actvitiesTypeId,
			String authorName, String coverImageUrl, String articleTitle,
			String articleAbstract) {
		this.publicityDataId = publicityDataId;
		this.authorId = authorId;
		this.commentNum = commentNum;
		this.praiseClickNum = praiseClickNum;
		this.state = state;
		this.createDate = createDate;
		this.others = others;
		this.actvitiesTypeId = actvitiesTypeId;
		this.authorName = authorName;
		this.coverImageUrl = coverImageUrl;
		this.articleTitle = articleTitle;
		this.articleAbstract = articleAbstract;
	}

	// Property accessors

	public Integer getPublicityDataId() {
		return this.publicityDataId;
	}

	public void setPublicityDataId(Integer publicityDataId) {
		this.publicityDataId = publicityDataId;
	}

	public Integer getAuthorId() {
		return this.authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
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

	public String getOthers() {
		return this.others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	public Integer getActvitiesTypeId() {
		return this.actvitiesTypeId;
	}

	public void setActvitiesTypeId(Integer actvitiesTypeId) {
		this.actvitiesTypeId = actvitiesTypeId;
	}

	public String getAuthorName() {
		return this.authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getCoverImageUrl() {
		return this.coverImageUrl;
	}

	public void setCoverImageUrl(String coverImageUrl) {
		this.coverImageUrl = coverImageUrl;
	}

	public String getArticleTitle() {
		return this.articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getArticleAbstract() {
		return this.articleAbstract;
	}

	public void setArticleAbstract(String articleAbstract) {
		this.articleAbstract = articleAbstract;
	}

}