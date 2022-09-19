package com.kh.fivechef.fridge.domain;

import java.sql.Date;

public class Fridge {
	private int fridgeNo;
	private String fridgeName;
	private Date enrollDate;
	private String fridgeFilename;
	private String fridgeFileRename;
	private String fridgeFilepath;
	private String userId;
	
	
	public int getFridgeNo() {
		return fridgeNo;
	}
	public void setFridgeNo(int fridgeNo) {
		this.fridgeNo = fridgeNo;
	}
	public String getFridgeName() {
		return fridgeName;
	}
	public void setFridgeName(String fridgeName) {
		this.fridgeName = fridgeName;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	public String getFridgeFilename() {
		return fridgeFilename;
	}
	public void setFridgeFilename(String fridgeFilename) {
		this.fridgeFilename = fridgeFilename;
	}
	public String getFridgeFileRename() {
		return fridgeFileRename;
	}
	public void setFridgeFileRename(String fridgeFileRename) {
		this.fridgeFileRename = fridgeFileRename;
	}
	public String getFridgeFilepath() {
		return fridgeFilepath;
	}
	public void setFridgeFilepath(String fridgeFilepath) {
		this.fridgeFilepath = fridgeFilepath;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	@Override
	public String toString() {
		return "Fridge [fridgeNo=" + fridgeNo + ", fridgeName=" + fridgeName + ", enrollDate=" + enrollDate
				+ ", fridgeFilename=" + fridgeFilename + ", fridgeFileRename=" + fridgeFileRename + ", fridgeFilepath="
				+ fridgeFilepath + ", userId=" + userId + "]";
	}
	
	
}
