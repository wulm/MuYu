package com.bean;

import java.sql.Timestamp;

/**
 * MxActivitiesMySpaceComment entity. @author MyEclipse Persistence Tools
 */

public class MxActivitiesMySpaceComment implements java.io.Serializable {

	// Fields

	private Integer commentId;
	private Integer myspaceId;
	private Integer submitUserId;
	private Integer state;
	private String commentTxt;
	private Integer praiseClickNum;
	private Timestamp createDate;
	private String others;

	// Constructors

	/** default constructor */
	public MxActivitiesMySpaceComment() {
	}

	/** minimal constructor */
	public MxActivitiesMySpaceComment(Integer commentId, Integer myspaceId,
			Integer submitUserId, Integer state, String commentTxt,
			Integer praiseClickNum, Timestamp createDate) {
		this.commentId = commentId;
		this.myspaceId = myspaceId;
		this.submitUserId = submitUserId;
		this.state = state;
		this.commentTxt = commentTxt;
		this.praiseClickNum = praiseClickNum;
		this.createDate = createDate;
	}

	/** full constructor */
	public MxActivitiesMySpaceComment(Integer commentId, Integer myspaceId,
			Integer submitUserId, Integer state, String commentTxt,
			Integer praiseClickNum, Timestamp createDate, String others) {
		this.commentId = commentId;
		this.myspaceId = myspaceId;
		this.submitUserId = submitUserId;
		this.state = state;
		this.commentTxt = commentTxt;
		this.praiseClickNum = praiseClickNum;
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

	public Integer getMyspaceId() {
		return this.myspaceId;
	}

	public void setMyspaceId(Integer myspaceId) {
		this.myspaceId = myspaceId;
	}

	public Integer getSubmitUserId() {
		return this.submitUserId;
	}

	public void setSubmitUserId(Integer submitUserId) {
		this.submitUserId = submitUserId;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
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