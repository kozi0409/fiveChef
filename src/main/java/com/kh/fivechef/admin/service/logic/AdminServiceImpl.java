package com.kh.fivechef.admin.service.logic;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.fivechef.admin.domain.Admin;
import com.kh.fivechef.admin.service.AdminService;
import com.kh.fivechef.admin.store.AdminStore;
import com.kh.fivechef.admin.store.logic.AdminStoreLogic;
@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private SqlSessionTemplate session;
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




}
