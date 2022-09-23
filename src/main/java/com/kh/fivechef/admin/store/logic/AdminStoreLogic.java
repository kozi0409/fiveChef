package com.kh.fivechef.admin.store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.fivechef.admin.domain.Admin;
import com.kh.fivechef.admin.store.AdminStore;
import com.kh.fivechef.qna.domain.QnA;
import com.kh.fivechef.user.domain.User;
import com.kh.fivechef.user.store.UserStore;

@Repository
public class AdminStoreLogic implements AdminStore{

	@Autowired
	private UserStore uStore;
	
	@Override
	public Admin selectLoginAdmin(SqlSession session, Admin admin) {
		Admin aOne = session.selectOne("AdminMapper.selectLoginOne", admin);
		return aOne;
	}

	@Override
	public Admin selectOneById(SqlSession session, String adminId) {
		Admin admin = session.selectOne("AdminMapper.selectOneById", adminId);
		return admin;
	}
	
	@Override
	public int insertAdmin(SqlSession session, Admin admin) {
		int result = session.insert("AdminMapper.insertAdmin", admin);
		return result;
	}

	@Override
	public int updateAdmin(SqlSession session, Admin admin) {
		int result = session.update("AdminMapper.updateAdmin", admin);
		return result;
	}

	@Override
	public int deleteAdmin(SqlSession session, String adminId) {
		int result = session.update("AdminMapper.deleteAdmin", adminId);
		return result;
	}

	@Override
	public List<Admin> selectAllAdmin(SqlSession session, int currentPage, int adminLimit) {
		int offset = (currentPage-1)*adminLimit;
		RowBounds rowBounds = new RowBounds(offset, adminLimit);
		List<Admin> aList = session.selectList("AdminMapper.selectAllAdmin", null, rowBounds);
		return aList;
	}
	
	
	//회원관리
	@Override
	public List<User> selectAllUser(SqlSession session, int currentPage, int userLimit) {
		int offset = (currentPage-1)*userLimit;
		RowBounds rowBounds = new RowBounds(offset, userLimit);
		List<User> uList = session.selectList("AdminMapper.selectAllUser", null, rowBounds);
		return uList;
	}

	@Override
	public int selectTotalCount(SqlSession session, String searchCondition, String searchValue) {
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("searchCondition", searchCondition);
		paramMap.put("searchValue", searchValue);
		int totalCount = session.selectOne("AdminMapper.selectTotalCount", paramMap);
		return totalCount;
	}

	@Override
	public int deleteOneById(SqlSession session, String adminId) {
		int result = session.delete("AdminMapper.deleteMasterAdmin", adminId);
		return result;
	}

	@Override
	public User printOneByUserId(SqlSession session, String userId) {
		User user = session.selectOne("AdminMapper.selectOneUser", userId);
		return user;
	}

	@Override
	public int removeOneByUserId(SqlSession session, String userId) {
		int result = session.delete("AdminMapper.deleteMasterUser", userId);
		return result;
	}

	@Override
	public int modifyUser(SqlSession session, User user) {
		int result = session.update("AdminMapper.modifyUser", user);
		return result;
	}

	@Override
	public List<Admin> selectAllByAdminValue(
			SqlSession session
			, String searchCondition
			, String searchValue
			, int currentPage, int adminLimit) {
		int offset = (currentPage-1)*adminLimit;
		RowBounds rowBounds 
		= new RowBounds(offset, adminLimit);
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("searchCondition", searchCondition);
		List<Admin> bList 
		= session.selectList("AdminMapper.selectAllByAdminValue"
				, paramMap, rowBounds);
		return bList;
	}

	@Override
	public List<User> selectAllByUserValue(
			SqlSession session
			, String searchCondition
			, String searchValue,
			int currentPage, int userLimit) {
		int offset = (currentPage-1)*userLimit;
		RowBounds rowBounds 
		= new RowBounds(offset, userLimit);
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("searchCondition", searchCondition);
		List<User> uList 
		= session.selectList("AdminMapper.selectAllByUserValue"
				, paramMap, rowBounds);
		return uList;
	}

	
	@Override
	public List<QnA> printAllQna(SqlSession session, int currentPage, int qnaLimit) {
		// TODO Auto-generated method stub
		return null;
	}



//	@Override
//	public List<QnA> selectAllQna(SqlSession session, int currentPage, int qnaLimit) {
//		int offset = (currentPage-1)*qnaLimit;
//		RowBounds rowBounds = new RowBounds(offset, qnaLimit);
//		List<QnA> qList = session.select
//		return qList;
//	}


}
