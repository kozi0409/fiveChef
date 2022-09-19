package com.kh.fivechef.recipe.store;

import org.apache.ibatis.session.SqlSession;

import com.kh.fivechef.recipe.domain.Recipe;

public interface RecipeStore {

	public int insertRecipe(SqlSession session, Recipe recipe);

}
