package com.kh.fivechef.admin.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.fivechef.admin.domain.Admin;
import com.kh.fivechef.admin.service.AdminService;
import com.kh.fivechef.admin.store.AdminStore;
import com.kh.fivechef.community.domain.Community;
import com.kh.fivechef.qna.domain.QnA;
import com.kh.fivechef.recipe.domain.Recipe;
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
	public int removeOneById(String adminId) {
		int result = aStore.deleteOneById(session, adminId);
		return result;
	}

	//회원관리
	@Override
	public List<User> printAllUser(int currentPage, int userLimit)  {
		List<User> uList = aStore.selectAllUser(session, currentPage, userLimit);
		return uList;
	}

	@Override
	public int getTotalUserCount(String searchCondition, String searchValue) {
		int totalUserCount = aStore.selectTotalUserCount(session, searchCondition, searchValue);
		return totalUserCount;
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

	@Override
	public List<QnA> printAllQna(int currentPage, int qnaLimit) {
		List<QnA> aList = aStore.selectAllQna(session, currentPage, qnaLimit);
		return aList;
	}

	@Override
	public int getTotalQnaCount(String searchCondition, String searchValue) {
		int totalQnaCount = aStore.selectTotalQnaCount(session, searchCondition, searchValue);
		return totalQnaCount;
	}

	@Override
	public QnA printOneByQna(Integer questionNo) {
		QnA qna = aStore.selectOneByQnaNo(session, questionNo);
		return qna;
	}

	@Override
	public int answerQna(QnA qna) {
		int result = aStore.insertAnswer(session, qna);
		return result;
	}

	@Override
	public List<QnA> printAllByQnaValue(String searchCondition, String searchValue, int currentPage, int qnaLimit) {
		List<QnA> qList = aStore.selectAllbyQnaValue(
				session
				, searchCondition
				, searchValue
				, currentPage
				, qnaLimit);
		return qList;
	}

	@Override
	public Admin findAdminId(String adminEmail) {
		Admin findId = aStore.selectAdminId(session, adminEmail);
		return findId;
	}

	@Override
	public Admin findAdminPwd(String adminId, String adminEmail) {
		Admin findPwd = aStore.selectAdminPwd(session, adminId, adminEmail);
		return findPwd;
	}

	@Override
	public List<User> printNewUser() {
		List<User> newUser = aStore.selectNewUser(session);
		return newUser;
	}

	@Override
	public List<Community> printNewCommunity() {
		List<Community> newComm = aStore.selectNewComm(session);
		return newComm;
	}

	@Override
	public List<QnA> printNewQna() {
		List<QnA> newQna = aStore.selectNewQna(session);
		return newQna;
	}

	@Override
	public List<Recipe> printNewRecipe() {
		List<Recipe> newRecipe = aStore.selectNewRecipe(session);
		return newRecipe;
	}


	

}
