package com.kh.fivechef.admin.store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.fivechef.admin.domain.Admin;
import com.kh.fivechef.admin.store.AdminStore;
@Repository
public class AdminStoreLogic implements AdminStore{

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
	public List<Admin> selectAllAdmin(SqlSession session) {
		List<Admin> adList = session.selectList("AdminMapper.selectAllAdmin");
		return adList;
	}

	@Override
	public int selectTotalCount(SqlSession session, String searchCondition, String searchValue) {
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("searchCondition", searchCondition);
		paramMap.put("searchValue", searchValue);
		int totalACount = session.selectOne("AdminMapper.selectTotalCount", paramMap);
		return totalACount;
	}
}
