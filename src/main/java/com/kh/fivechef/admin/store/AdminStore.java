package com.kh.fivechef.admin.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.fivechef.admin.domain.Admin;
import com.kh.fivechef.user.domain.User;

public interface AdminStore {   
	//selectLoginAdmin
	public Admin selectLoginAdmin(SqlSession session, Admin admin);
	//selectOneById
	public Admin selectOneById(SqlSession session, String adminId);
	//insertAdmin
	public int insertAdmin(SqlSession session, Admin admin);
	//updateAdmin
	public int updateAdmin(SqlSession session, Admin admin);
	//deleteAdmin
	public int deleteAdmin(SqlSession session, String adminId);
	
	//관리자 리스트출력
	public List<Admin> selectAllAdmin(SqlSession session, int currentPage, int adminLimit);
	//관리자 
	public int selectTotalCount(SqlSession session, String searchCondition, String searchValue);
	//관리자 삭제
//	public int removeOneById(SqlSession session, String adminId);
	public int deleteOneById(SqlSession session, String adminId);
	
	public List<User> selectAllUser(SqlSession session);
	

	public int modifyAdminMaster(SqlSession session, Admin admin);
	
	

		
}
