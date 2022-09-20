package com.kh.fivechef.community.domain;

import java.sql.Date;

public class Community {
	private int communityNo;
	private String cBoardCode;
	private String communityTitle;
	private String communityWriter;
	private String communityContents;
	private String communityPrice;
	private String communitySalePage;
	private String communityFileName;
	private String communityFileRename;
	private String communityFilePath;
	private Date cEnrollDate;
	private Date cUpdateDate;
	private int boardCount;
	
	public int getCommunityNo() {
		return communityNo;
	}
	public void setCommunityNo(int communityNo) {
		this.communityNo = communityNo;
	}
	public String getcBoardCode() {
		return cBoardCode;
	}
	public void setcBoardCode(String cBoardCode) {
		this.cBoardCode = cBoardCode;
	}
	public String getCommunityTitle() {
		return communityTitle;
	}
	public void setCommunityTitle(String communityTitle) {
		this.communityTitle = communityTitle;
	}
	public String getCommunityWriter() {
		return communityWriter;
	}
	public void setCommunityWriter(String communityWriter) {
		this.communityWriter = communityWriter;
	}
	public String getCommunityContents() {
		return communityContents;
	}
	public void setCommunityContents(String communityContents) {
		this.communityContents = communityContents;
	}
	public String getCommunityPrice() {
		return communityPrice;
	}
	public void setCommunityPrice(String communityPrice) {
		this.communityPrice = communityPrice;
	}
	public String getCommunitySalePage() {
		return communitySalePage;
	}
	public void setCommunitySalePage(String communitySalePage) {
		this.communitySalePage = communitySalePage;
	}
	public String getCommunityFileName() {
		return communityFileName;
	}
	public void setCommunityFileName(String communityFileName) {
		this.communityFileName = communityFileName;
	}
	public String getCommunityFileRename() {
		return communityFileRename;
	}
	public void setCommunityFileRename(String communityFileRename) {
		this.communityFileRename = communityFileRename;
	}
	public String getCommunityFilePath() {
		return communityFilePath;
	}
	public void setCommunityFilePath(String communityFilePath) {
		this.communityFilePath = communityFilePath;
	}
	public Date getcEnrollDate() {
		return cEnrollDate;
	}
	public void setcEnrollDate(Date cEnrollDate) {
		this.cEnrollDate = cEnrollDate;
	}
	public Date getcUpdateDate() {
		return cUpdateDate;
	}
	public void setcUpdateDate(Date cUpdateDate) {
		this.cUpdateDate = cUpdateDate;
	}
	public int getBoardCount() {
		return boardCount;
	}
	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}
	
	@Override
	public String toString() {
		return "Community [communityNo=" + communityNo + ", cBoardCode=" + cBoardCode + ", communityTitle="
				+ communityTitle + ", communityWriter=" + communityWriter + ", communityContents=" + communityContents
				+ ", communityPrice=" + communityPrice + ", communitySalePage=" + communitySalePage
				+ ", communityFileName=" + communityFileName + ", communityFileRename=" + communityFileRename
				+ ", communityFilePath=" + communityFilePath + ", cEnrollDate=" + cEnrollDate + ", cUpdateDate="
				+ cUpdateDate + ", boardCount=" + boardCount + "]";
	}
	
}
