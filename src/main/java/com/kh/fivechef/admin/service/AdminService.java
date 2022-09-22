package com.kh.fivechef.admin.service;

import java.util.List;

import com.kh.fivechef.admin.domain.Admin;
import com.kh.fivechef.user.domain.User;

public interface AdminService {
	//관리자 관리
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
	
	//관리자 목록 출력
	public List<Admin> printAllAdmin(int currentPage, int adminLimit);
	//관리자 검색
	public int getTotalCount(String searchCondition, String searchValue);
	//관리자 삭제
	public int removeOneById(String adminId);
	
	
	//회원목록 출력=>admin
	//printAllUser
	public List<User> printAllUser();
	//마스터가 관리회원정보 수정

	public int modifyAdminMaster(Admin admin);
	
	
}
