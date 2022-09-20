package com.kh.fivechef.recipe.store;

import org.apache.ibatis.session.SqlSession;

import com.kh.fivechef.recipe.domain.Ingradient;
import com.kh.fivechef.recipe.domain.Order;
import com.kh.fivechef.recipe.domain.Recipe;

public interface RecipeStore {

	public int insertRecipe(SqlSession session, Recipe recipe);

	public int insertIngradient(SqlSession session, Ingradient ing);

	public int insertOrder(SqlSession session, Order order);

}
