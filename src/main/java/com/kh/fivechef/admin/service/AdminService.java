package com.kh.fivechef.admin.service;

import com.kh.fivechef.admin.domain.Admin;

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
	
}
