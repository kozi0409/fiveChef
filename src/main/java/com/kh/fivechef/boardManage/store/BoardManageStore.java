package com.kh.fivechef.boardManage.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.fivechef.community.domain.CReply;
import com.kh.fivechef.community.domain.Community;
import com.kh.fivechef.fridge.domain.SmallCategory;
import com.kh.fivechef.recipe.domain.ComPhoto;
import com.kh.fivechef.recipe.domain.Ingradient;
import com.kh.fivechef.recipe.domain.Like;
import com.kh.fivechef.recipe.domain.Order;
import com.kh.fivechef.recipe.domain.Recipe;
import com.kh.fivechef.recipe.domain.WhatRecipe;

public interface BoardManageStore {

	public	List<Community> selectAllPost(SqlSession session, int currentPage, int communityLimit);

	public	Community selectOneByPostNo(SqlSession session, Integer communityNo);

	public	int updatePostCount(SqlSession session, int communityNo);

	public	int deleteOneByPostNo(SqlSession session, int communityNo);

	// 검색
	public int selectPostTotalCount(SqlSession session, String searchCondition, String searchValue);
	
	public List<Community> selectAllByPostValue(SqlSession session, String searchCondition, String searchValue,
			int currentPage, int communityLimit);
	
	// 수정
	public int updatePost(SqlSession session, Community community);

	public List<CReply> selectAllReply(SqlSession session, Integer refCommunityNo);

	////////////////////////////////////////////////////////////////////////
	// 레시피 관리 코드
	
	// 리스트,검색
	public int selectCountAllRecipe(SqlSession session, String searchCondition, String searchValue);
	// 리스트
	public List<Recipe> selectAllRecipe(SqlSession session, int currentPage, int limit);
	// 상세 조회
	public Recipe selectOneByRecipeNo(SqlSession session, Integer recipeNo);
	// 상세 조회
	public List<Ingradient> selectAllIng(SqlSession session, Integer recipeNo);
	// 상세 조회
	public List<Order> selectAllOrder(SqlSession session, Integer recipeNo);
	// 상세 조회
	public List<ComPhoto> selectAllComPhoto(SqlSession session, Integer recipeNo);
	// 상세 조회
	public int selectCheckLikeId(SqlSession session, Like like);
	public int updateBoardCount(SqlSession session, Integer recipeNo);
	public List<WhatRecipe> selectWhatRecipe(SqlSession session);

	//검색
	public List<Recipe> selectAllByRecipeValue(SqlSession session, String searchCondition, String searchValue,
			int currentPage, int recipeLimit);

	public int updateRecipe(SqlSession session, Recipe recipe);

	public int updateIng(SqlSession session, Ingradient ingradient);

	public int updateOrder(SqlSession session, Order order);

	public int updateCom(SqlSession session, ComPhoto comPhoto);
	
	public int removeRecipeUpdate(SqlSession session, Integer recipeNo);
	
	public List<SmallCategory> selectAllSmallCat(SqlSession session);

	public Recipe selectRecipeByRNo(SqlSession session, int recipeNo);

	public List<Ingradient> selectIngByRNo(SqlSession session, int recipeNo);

	public List<Order> selectOrderByRNo(SqlSession session, int recipeNo);

	public List<ComPhoto> selectComByRNo(SqlSession session, int recipeNo);
}
