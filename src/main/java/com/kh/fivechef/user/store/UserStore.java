package com.kh.fivechef.user.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import com.kh.fivechef.user.domain.User;

public interface UserStore {
	
	public int insertUser(SqlSession session, User user);

	public User selectLoginUser(SqlSession session, User user);

	public User selectOneUser(SqlSessionTemplate session, String userId);

	public int deleteUser(SqlSessionTemplate session, String userId);

	public int updateUser(SqlSessionTemplate session, User user);
	
	public List<User> selectAllUser(SqlSession session);
}
