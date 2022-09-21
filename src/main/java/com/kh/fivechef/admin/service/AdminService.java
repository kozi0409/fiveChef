package com.kh.fivechef.admin.service;

import java.util.List;

import com.kh.fivechef.admin.domain.Admin;
import com.kh.fivechef.user.domain.User;

public interface AdminService {
	//loginAdmin
	public Admin loginAdmin(Admin admin);
	//printOneByID
	public Admin printOneById(String adminId);
	//registerAdmin
	public int registerAdmin(Admin admin);
	//modifyAdmin
	public int modifyAdmin(Admin admin);
	//removeAdmin
	public int removeAdmin(String adminId);
	//관리자목록 출력
	public List<Admin> printAllAdmin();
	

	
}
