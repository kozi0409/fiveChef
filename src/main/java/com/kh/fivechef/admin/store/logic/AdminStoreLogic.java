package com.kh.fivechef.admin.store.logic;

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

}
