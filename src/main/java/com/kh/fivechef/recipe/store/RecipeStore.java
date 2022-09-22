package com.kh.fivechef.recipe.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import com.kh.fivechef.recipe.domain.ComPhoto;
import com.kh.fivechef.recipe.domain.Ingradient;
import com.kh.fivechef.recipe.domain.Like;
import com.kh.fivechef.recipe.domain.Order;
import com.kh.fivechef.recipe.domain.Recipe;

public interface RecipeStore {

	public int insertRecipe(SqlSession session, Recipe recipe);

	public int insertIngradient(SqlSession session, Ingradient ing);

	public int insertOrder(SqlSession session, Order order);

	public int insertComPhoto(SqlSession session, ComPhoto comPhoto);

	public List<Recipe> selectAllRecipe(SqlSession session, String listValue, int currentPage, int Limit);

	public int selectCountAllRecipe(SqlSession session);

	public Recipe selectOneByRecipeNo(SqlSession session, Integer recipeNo);

	public List<Ingradient> selectAllIng(SqlSession session, Integer recipeNo);

	public List<Order> selectAllOrder(SqlSession session, Integer recipeNo);

	public List<ComPhoto> selectAllComPhoto(SqlSession session, Integer recipeNo);

	public int updateBoardCount(SqlSession session, Integer recipeNo);

	public int selectCheckLikeId(SqlSession session, Like like);

	public int insertLike(SqlSession session, Like like);

	public int updateLikeCount(SqlSession session, Like like);

	public int deleteLike(SqlSession session, Like like);

	public int updateDLikeCount(SqlSession session, Like like);



}
