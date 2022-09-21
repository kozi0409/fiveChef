package com.kh.fivechef.admin.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.fivechef.admin.domain.Admin;

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
	
	public List<Admin> selectAllAdmin(SqlSession session);
	
	//관리자 리스트 출력
	public int selectTotalCount(SqlSession session, String searchCondition, String searchValue);
	

	
}
