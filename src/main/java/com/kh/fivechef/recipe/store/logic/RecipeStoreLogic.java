package com.kh.fivechef.recipe.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

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

}
