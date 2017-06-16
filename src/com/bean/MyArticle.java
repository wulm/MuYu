package com.bean;

import java.sql.Timestamp;

/**
 * MyArticle entity. @author MyEclipse Persistence Tools
 */

public class MyArticle implements java.io.Serializable {

	// Fields

	private Integer articleId;
	private String writerName;
	private Integer articleType;
	private String articleTitle;
	private String articleTitleImageUrl;
	private String articleLeadText;
	private Integer articleContentId;
	private Timestamp createDate;
	private Timestamp updateDate;
	private Integer state;
	private String others;

	// Constructors

	/** default constructor */
	public MyArticle() {
	}

	/** minimal constructor */
	public MyArticle(Integer articleId, String writerName, Integer articleType,
			String articleTitle, String articleTitleImageUrl,
			String articleLeadText, Integer articleContentId,
			Timestamp createDate, Timestamp updateDate, Integer state) {
		this.articleId = articleId;
		this.writerName = writerName;
		this.articleType = articleType;
		this.articleTitle = articleTitle;
		this.articleTitleImageUrl = articleTitleImageUrl;
		this.articleLeadText = articleLeadText;
		this.articleContentId = articleContentId;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.state = state;
	}

	/** full constructor */
	public MyArticle(Integer articleId, String writerName, Integer articleType,
			String articleTitle, String articleTitleImageUrl,
			String articleLeadText, Integer articleContentId,
			Timestamp createDate, Timestamp updateDate, Integer state,
			String others) {
		this.articleId = articleId;
		this.writerName = writerName;
		this.articleType = articleType;
		this.articleTitle = articleTitle;
		this.articleTitleImageUrl = articleTitleImageUrl;
		this.articleLeadText = articleLeadText;
		this.articleContentId = articleContentId;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.state = state;
		this.others = others;
	}

	// Property accessors

	public Integer getArticleId() {
		return this.articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public String getWriterName() {
		return this.writerName;
	}

	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}

	public Integer getArticleType() {
		return this.articleType;
	}

	public void setArticleType(Integer articleType) {
		this.articleType = articleType;
	}

	public String getArticleTitle() {
		return this.articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getArticleTitleImageUrl() {
		return this.articleTitleImageUrl;
	}

	public void setArticleTitleImageUrl(String articleTitleImageUrl) {
		this.articleTitleImageUrl = articleTitleImageUrl;
	}

	public String getArticleLeadText() {
		return this.articleLeadText;
	}

	public void setArticleLeadText(String articleLeadText) {
		this.articleLeadText = articleLeadText;
	}

	public Integer getArticleContentId() {
		return this.articleContentId;
	}

	public void setArticleContentId(Integer articleContentId) {
		this.articleContentId = articleContentId;
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