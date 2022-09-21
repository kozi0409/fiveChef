package com.kh.fivechef.recipe.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import com.kh.fivechef.recipe.domain.ComPhoto;
import com.kh.fivechef.recipe.domain.Ingradient;
import com.kh.fivechef.recipe.domain.Order;
import com.kh.fivechef.recipe.domain.Recipe;

public interface RecipeStore {

	public int insertRecipe(SqlSession session, Recipe recipe);

	public int insertIngradient(SqlSession session, Ingradient ing);

	public int insertOrder(SqlSession session, Order order);

	public int insertComPhoto(SqlSession session, ComPhoto comPhoto);

	public List<Recipe> selectAllRecipe(SqlSession session, String listValue);

	public int selectCountAllRecipe(SqlSession session);


}
