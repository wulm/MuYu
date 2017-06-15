package com.bean;

import java.util.Date;

/**
 * MxNewsComment entity. @author MyEclipse Persistence Tools
 */

public class MxNewsComment implements java.io.Serializable {

	// Fields

	private Integer commentId;
	private Integer newsId;
	private String commentTxt;
	private Integer praiseClickNum;
	private Date createDate;
	private String others;
	private Integer state;

	// Constructors

	/** default constructor */
	public MxNewsComment() {
	}

	/** minimal constructor */
	public MxNewsComment(Integer commentId, Integer newsId, String commentTxt,
			Integer praiseClickNum, Date createDate, Integer state) {
		this.commentId = commentId;
		this.newsId = newsId;
		this.commentTxt = commentTxt;
		this.praiseClickNum = praiseClickNum;
		this.createDate = createDate;
		this.state = state;
	}

	/** full constructor */
	public MxNewsComment(Integer commentId, Integer newsId, String commentTxt,
			Integer praiseClickNum, Date createDate, String others,
			Integer state) {
		this.commentId = commentId;
		this.newsId = newsId;
		this.commentTxt = commentTxt;
		this.praiseClickNum = praiseClickNum;
		this.createDate = createDate;
		this.others = others;
		this.state = state;
	}

	// Property accessors

	public Integer getCommentId() {
		return this.commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public Integer getNewsId() {
		return this.newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	public String getCommentTxt() {
		return this.commentTxt;
	}

	public void setCommentTxt(String commentTxt) {
		this.commentTxt = commentTxt;
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

	public String getOthers() {
		return this.others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}