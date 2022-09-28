package com.kh.fivechef.community.domain;

import java.sql.Date;

public class CReply {
	private int replyNo;
	private int refCommunityNo;
	private String replyContents;
	private String replyWriter;
	private Date rCreateDate;
	private Date rUpdateDate;
	private String cBoardCode;
	
	public int getReplyNo() {
		return replyNo;
	}
	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}
	public int getRefCommunityNo() {
		return refCommunityNo;
	}
	public void setRefCommunityNo(int refCommunityNo) {
		this.refCommunityNo = refCommunityNo;
	}
	public String getReplyContents() {
		return replyContents;
	}
	public void setReplyContents(String replyContents) {
		this.replyContents = replyContents;
	}
	public String getReplyWriter() {
		return replyWriter;
	}
	public void setReplyWriter(String replyWriter) {
		this.replyWriter = replyWriter;
	}
	public Date getrCreateDate() {
		return rCreateDate;
	}
	public void setrCreateDate(Date rCreateDate) {
		this.rCreateDate = rCreateDate;
	}
	public Date getrUpdateDate() {
		return rUpdateDate;
	}
	public void setrUpdateDate(Date rUpdateDate) {
		this.rUpdateDate = rUpdateDate;
	}
	public String getcBoardCode() {
		return cBoardCode;
	}
	public void setcBoardCode(String cBoardCode) {
		this.cBoardCode = cBoardCode;
	}
	
	@Override
	public String toString() {
		return "CReply [replyNo=" + replyNo + ", refCommunityNo=" + refCommunityNo + ", replyContents=" + replyContents
				+ ", replyWriter=" + replyWriter + ", rCreateDate=" + rCreateDate + ", rUpdateDate=" + rUpdateDate
				+ ", cBoardCode=" + cBoardCode + "]";
	}
	
}
