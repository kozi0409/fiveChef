package com.kh.fivechef.user.service.logic;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.fivechef.user.domain.User;
import com.kh.fivechef.user.service.UserService;
import com.kh.fivechef.user.store.UserStore;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private SqlSessionTemplate session;
	
	@Autowired
	private UserStore uStore;
	
	
	@Override
	public int registerUser(User user) {
		int result = uStore.insertUser(session, user);
		return result;
	}


	@Override
	public User loginUser(User user) {
		User uOne = uStore.selectLoginUser(session, user);
		return uOne;
	}


	@Override
	public User printOneUser(String userId) {
		User user = uStore.selectOneUser(session, userId);
		return user;
	}


	@Override
	public int removeUser(String userId) {
		int result = uStore.deleteUser(session, userId);
		return result;
	}


	@Override
	public int modifyUser(User user) {
		int result = uStore.updateUser(session, user);
		return result;
	}


	@Override
	public User findUserId(String userEmail) {
		User findId = uStore.selectUserId(session, userEmail);
		return findId;
	}
}
