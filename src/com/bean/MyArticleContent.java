package com.bean;

import java.sql.Timestamp;

/**
 * MyArticleContent entity. @author MyEclipse Persistence Tools
 */

public class MyArticleContent implements java.io.Serializable {

	// Fields

	private Integer articleContentId;
	private Integer articleId;
	private String articleContent;
	private String writerName;
	private String articleTitle;
	private Integer praiseClickNum;
	private Timestamp createDate;
	private Timestamp updateDate;
	private Integer state;
	private String others;

	// Constructors

	/** default constructor */
	public MyArticleContent() {
	}

	/** minimal constructor */
	public MyArticleContent(Integer articleContentId, Integer articleId,
			String articleContent, String writerName, String articleTitle,
			Integer praiseClickNum, Timestamp createDate, Timestamp updateDate,
			Integer state) {
		this.articleContentId = articleContentId;
		this.articleId = articleId;
		this.articleContent = articleContent;
		this.writerName = writerName;
		this.articleTitle = articleTitle;
		this.praiseClickNum = praiseClickNum;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.state = state;
	}

	/** full constructor */
	public MyArticleContent(Integer articleContentId, Integer articleId,
			String articleContent, String writerName, String articleTitle,
			Integer praiseClickNum, Timestamp createDate, Timestamp updateDate,
			Integer state, String others) {
		this.articleContentId = articleContentId;
		this.articleId = articleId;
		this.articleContent = articleContent;
		this.writerName = writerName;
		this.articleTitle = articleTitle;
		this.praiseClickNum = praiseClickNum;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.state = state;
		this.others = others;
	}

	// Property accessors

	public Integer getArticleContentId() {
		return this.articleContentId;
	}

	public void setArticleContentId(Integer articleContentId) {
		this.articleContentId = articleContentId;
	}

	public Integer getArticleId() {
		return this.articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public String getArticleContent() {
		return this.articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	public String getWriterName() {
		return this.writerName;
	}

	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}

	public String getArticleTitle() {
		return this.articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public Integer getPraiseClickNum() {
		return this.praiseClickNum;
	}

	public void setPraiseClickNum(Integer praiseClickNum) {
		this.praiseClickNum = praiseClickNum;
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

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getOthers() {
		return this.others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

}