package com.kh.fivechef.admin.domain;

import java.sql.Date;

import oracle.sql.DATE;

public class Admin {
	private String adminId;  	//아이디
	private String adminPwd;	//패스워드
	private String adminName;	//이름
	private String adminEmail;	//이메일
	private String adminPhone;	//전화번호
	private String adminAddr;	//주소
	private String adminScope;	//직무
	private String adminCode;	//직무코드
	private Date regdate;		//가입날짜
	private Date updateDate;	//정보수정 날짜
	private Date lastCnt_date;	//최종로그인 날짜
	private String aStatus;		//상태
	
	public Admin() {}
	
	public Admin(String adminId, String adminPwd) {
		super();
		this.adminId = adminId;
		this.adminPwd = adminPwd;
	}

	public Admin(String adminId, String adminPwd, String adminName, String adminEmail, 
			String adminPhone, String adminAddr) {
		super();
		this.adminId = adminId;
		this.adminPwd = adminPwd;
		this.adminName = adminName;
		this.adminEmail = adminEmail;
		this.adminPhone = adminPhone;
		this.adminAddr = adminAddr;
	}



	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminPwd() {
		return adminPwd;
	}

	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminPhone() {
		return adminPhone;
	}

	public void setAdminPhone(String adminPhone) {
		this.adminPhone = adminPhone;
	}

	public String getAdminAddr() {
		return adminAddr;
	}

	public void setAdminAddr(String adminAddr) {
		this.adminAddr = adminAddr;
	}

	public String getAdminScope() {
		return adminScope;
	}

	public void setAdminScope(String adminScope) {
		this.adminScope = adminScope;
	}

	public String getAdminCode() {
		return adminCode;
	}

	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getLastCnt_date() {
		return lastCnt_date;
	}

	public void setLastCnt_date(Date lastCnt_date) {
		this.lastCnt_date = lastCnt_date;
	}

	public String getaStatus() {
		return aStatus;
	}

	public void setaStatus(String aStatus) {
		this.aStatus = aStatus;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminPwd=" + adminPwd + ", adminName=" + adminName + ", adminEmail="
				+ adminEmail + ", adminBirth=" + ", adminPhone=" + adminPhone + ", adminAddr=" + adminAddr
				+ ", adminScope=" + adminScope + ", adminCode=" + adminCode + ", regdate=" + regdate + ", updateDate="
				+ updateDate + ", lastCnt_date=" + lastCnt_date + ", aStatus=" + aStatus + "]";
	}
	
	
}
