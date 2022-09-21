package com.kh.fivechef.recipe.store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.fivechef.recipe.domain.ComPhoto;
import com.kh.fivechef.recipe.domain.Ingradient;
import com.kh.fivechef.recipe.domain.Order;
import com.kh.fivechef.recipe.domain.Recipe;
import com.kh.fivechef.recipe.store.RecipeStore;
@Repository
public class RecipeStoreLogic implements RecipeStore{

	@Override
	public int insertRecipe(SqlSession session, Recipe recipe) {
		int result = session.insert("RecipeMapper.insertRecipe",recipe);
		return result;
	}

	@Override
	public int insertIngradient(SqlSession session, Ingradient ing) {
		int result = session.insert("RecipeMapper.insertIngradient",ing);
		return result;
	}

	@Override
	public int insertOrder(SqlSession session, Order order) {
		int result = session.insert("RecipeMapper.insertOrder",order);
		return result;
	}

	@Override
	public int insertComPhoto(SqlSession session, ComPhoto comPhoto) {
		int result = session.insert("RecipeMapper.insertComPhoto",comPhoto);
		return result;
	}

	@Override
	public List<Recipe> selectAllRecipe(SqlSession session, String listValue) {
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("category", listValue);
		List<Recipe> rList = session.selectList("RecipeMapper.selectAllRecipe",paramMap);
		return rList;
	}

	@Override
	public int selectCountAllRecipe(SqlSession session) {
		int count = session.selectOne("RecipeMapper.selectCountAllRecipe");
		return count;
	}

}
