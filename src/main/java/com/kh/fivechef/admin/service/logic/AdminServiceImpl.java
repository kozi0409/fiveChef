package com.kh.fivechef.admin.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.fivechef.admin.domain.Admin;
import com.kh.fivechef.admin.service.AdminService;
import com.kh.fivechef.admin.store.AdminStore;
import com.kh.fivechef.user.domain.User;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private SqlSession session;
	@Autowired
	private AdminStore aStore;

	@Override
	public Admin loginAdmin(Admin admin) {
		Admin aOne = aStore.selectLoginAdmin(session, admin);
		return aOne;
	}

	@Override
	public Admin printOneById(String adminId) {
		Admin admin = aStore.selectOneById(session, adminId);
		return admin;
	}
	
	@Override
	public int registerAdmin(Admin admin) {
		int result = aStore.insertAdmin(session, admin);
		return result;
	}

	@Override
	public int modifyAdmin(Admin admin) {
		int result = aStore.updateAdmin(session, admin);
		return result;
	}

	@Override
	public int removeAdmin(String adminId) {
		int result = aStore.deleteAdmin(session, adminId);
		return result;
	}

	//회원관리
	@Override
	public List<User> printAllUser() {
		List<User> uList = aStore.selectAllUser(session);
		return uList;
	}

	//관리자회원 목록 - 페이징처리 포함
	@Override
	public List<Admin> printAllAdmin(int currentPage, int adminLimit) {
		List<Admin> aList = aStore.selectAllAdmin(session, currentPage, adminLimit);
		return aList;
	}

	@Override
	public int getTotalCount(String searchCondition, String searchValue) {
		int totalCount = aStore.selectTotalCount(session, searchCondition, searchValue);
		return totalCount;
	}

	@Override
	public int removeOneById(String adminId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyAdminMaster(Admin admin) {
		int result = aStore.modifyAdminMaster(session, admin);
		return result;
	}

//	@Override
//	public int removeOneById(String adminId) {
//		int result = aStore.deleteOneById(session, adminId);
//		return result;
//	}
//

	

}
