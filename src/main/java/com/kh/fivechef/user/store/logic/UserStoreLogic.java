package com.kh.fivechef.user.store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.fivechef.recipe.domain.Recipe;
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

	@Override
	public User selectUserId(SqlSessionTemplate session, String userEmail) {
		User findId = session.selectOne("UserMapper.selectUserId", userEmail);
		return findId;
	}

	@Override
	public User selectUserPwd(SqlSessionTemplate session, String userId, String userEmail) {
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("userId", userId);
		paramMap.put("userEmail", userEmail);
		User searchPwd = session.selectOne("UserMapper.selectUserPwd", paramMap);
		return searchPwd;
	}

	@Override
	public List<Recipe> selectMyRecipe(SqlSessionTemplate session, String userId,  String listValue, int currentPage, int recipeLimit) {
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("userId", userId);
		paramMap.put("category", listValue);
		int offset=(currentPage-1)*recipeLimit;
		RowBounds rowBounds = new RowBounds(offset,recipeLimit);
		List<Recipe> rList = session.selectList("UserMapper.selectMyRecipe",paramMap,rowBounds);
		return rList;
	}

	@Override
	public int selectCountMyRecipe(SqlSessionTemplate session) {
		int count = session.selectOne("UserMapper.selectCountMyRecipe");
		return count;
	}
}
