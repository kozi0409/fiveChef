package com.kh.fivechef.user.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.fivechef.user.domain.User;
import com.kh.fivechef.user.store.UserStore;

@Repository
public class UserStoreLogic implements UserStore{
	
	@Override
	public int insertUser(SqlSession session, User user) {
		int result = session.insert("UserMapper.insertUser", user);
		return result;
	}

	@Override
	public User selectLoginUser(SqlSession session, User user) {
		User uOne = session.selectOne("UserMapper.selectLogin", user);
		return uOne;
	}

	@Override
	public User selectOneUser(SqlSessionTemplate session, String userId) {
		User user = session.selectOne("UserMapper.selectOneUser", userId);
		return user;
	}

	@Override
	public int deleteUser(SqlSessionTemplate session, String userId) {
		int result = session.update("UserMapper.deleteUser", userId);
		return result;
	}

	@Override
	public int updateUser(SqlSessionTemplate session, User user) {
		int result = session.update("UserMapper.updateUser", user);
		return result;
	}
}
