package com.kh.fivechef.user.domain;

import java.sql.Date;

public class User {
	private String userId;
	private String userPwd;
	private String userName;
	private String userPhone;
	private String userEmail;
	private String userBirth;
	private String userPhotoName;
	private String userPhotoRename;
	private String userPhotoPath;
	private Date uEnrollDate;
	private String uStatus;
	
public User() {}
	
	public User(String userId, String userPwd) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}
	public String getUserPhotoName() {
		return userPhotoName;
	}
	public void setUserPhotoName(String userPhotoName) {
		this.userPhotoName = userPhotoName;
	}
	public String getUserPhotoRename() {
		return userPhotoRename;
	}
	public void setUserPhotoRename(String userPhotoRename) {
		this.userPhotoRename = userPhotoRename;
	}
	public String getUserPhotoPath() {
		return userPhotoPath;
	}
	public void setUserPhotoPath(String userPhotoPath) {
		this.userPhotoPath = userPhotoPath;
	}
	public Date getuEnrollDate() {
		return uEnrollDate;
	}
	public void setuEnrollDate(Date uEnrollDate) {
		this.uEnrollDate = uEnrollDate;
	}
	public String getuStatus() {
		return uStatus;
	}
	public void setuStatus(String uStatus) {
		this.uStatus = uStatus;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", userPhone=" + userPhone
				+ ", userEmail=" + userEmail + ", userBirth=" + userBirth + ", userPhotoName=" + userPhotoName
				+ ", userPhotoRename=" + userPhotoRename + ", userPhotoPath=" + userPhotoPath + ", uEnrollDate="
				+ uEnrollDate + ", uStatus=" + uStatus + "]";
	}
}
