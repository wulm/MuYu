package com.bean;

import java.sql.Timestamp;

/**
 * MxActivitiesPublicityComment entity. @author MyEclipse Persistence Tools
 */

public class MxActivitiesPublicityComment implements java.io.Serializable {

	// Fields

	private Integer commentId;
	private Integer publicityDataId;
	private String commentTxt;
	private Integer praiseClickNum;
	private Integer commentUserId;
	private Timestamp createDate;
	private String others;

	// Constructors

	/** default constructor */
	public MxActivitiesPublicityComment() {
	}

	/** minimal constructor */
	public MxActivitiesPublicityComment(Integer commentId,
			Integer publicityDataId, String commentTxt, Integer praiseClickNum,
			Integer commentUserId, Timestamp createDate) {
		this.commentId = commentId;
		this.publicityDataId = publicityDataId;
		this.commentTxt = commentTxt;
		this.praiseClickNum = praiseClickNum;
		this.commentUserId = commentUserId;
		this.createDate = createDate;
	}

	/** full constructor */
	public MxActivitiesPublicityComment(Integer commentId,
			Integer publicityDataId, String commentTxt, Integer praiseClickNum,
			Integer commentUserId, Timestamp createDate, String others) {
		this.commentId = commentId;
		this.publicityDataId = publicityDataId;
		this.commentTxt = commentTxt;
		this.praiseClickNum = praiseClickNum;
		this.commentUserId = commentUserId;
		this.createDate = createDate;
		this.others = others;
	}

	// Property accessors

	public Integer getCommentId() {
		return this.commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public Integer getPublicityDataId() {
		return this.publicityDataId;
	}

	public void setPublicityDataId(Integer publicityDataId) {
		this.publicityDataId = publicityDataId;
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

	public Integer getCommentUserId() {
		return this.commentUserId;
	}

	public void setCommentUserId(Integer commentUserId) {
		this.commentUserId = commentUserId;
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