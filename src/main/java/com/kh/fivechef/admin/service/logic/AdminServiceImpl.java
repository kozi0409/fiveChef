package com.kh.fivechef.admin.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.fivechef.admin.domain.Admin;
import com.kh.fivechef.admin.service.AdminService;
import com.kh.fivechef.admin.store.AdminStore;
import com.kh.fivechef.qna.domain.QnA;
import com.kh.fivechef.qna.store.QnAStore;
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
	public List<User> printAllUser(int currentPage, int userLimit)  {
		List<User> uList = aStore.selectAllUser(session, currentPage, userLimit);
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
	public int getTotalUserCount(String searchUCondition, String searchUValue) {
		int totalUserCount = aStore.selectTotalCount(session, searchUCondition, searchUValue);
		return totalUserCount;
	}
	
	@Override
	public int getTotalQnaCount(String searchQCondition, String searchQValue) {
		int totalQnaCount = aStore.selectTotalCount(session, searchQCondition, searchQValue);
		return totalQnaCount;
	}


	@Override
	public int removeOneById(String adminId) {
		int result = aStore.deleteOneById(session, adminId);
		return result;
	}

	@Override
	public User printOneByUserId(String userId) {
		User user = aStore.printOneByUserId(session, userId);
		return user;
	}

	@Override
	public int removeOneByUserId(String userId) {
		int reult = aStore.removeOneByUserId(session, userId);
		return reult;
	}

	@Override
	public int modifyUser(User user) {
		int reult = aStore.modifyUser(session, user);
		return reult;
	}

	@Override
	public List<QnA> printAllQna(int currentPage, int qnaLimit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Admin> printAllByAdminValue(
			String searchCondition, String searchValue
			, int currentPage,int adminLimit) {
		List<Admin> aList 
		= aStore.selectAllByAdminValue(
				session
				, searchCondition
				, searchValue
				, currentPage
				, adminLimit);
		return aList;
	}

	@Override
	public List<User> printAllByUserValue(
			String searchCondition, String searchValue
			, int currentPage, int userLimit) {
		List<User> uList 
		= aStore.selectAllByUserValue(
				session
				, searchCondition
				, searchValue
				, currentPage
				, userLimit);
		return uList;
	}


	

}
