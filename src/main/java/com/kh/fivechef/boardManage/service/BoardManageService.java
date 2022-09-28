package com.kh.fivechef.boardManage.service;

import java.util.List;

import com.kh.fivechef.community.domain.CReply;
import com.kh.fivechef.community.domain.Community;
import com.kh.fivechef.fridge.domain.SmallCategory;
import com.kh.fivechef.recipe.domain.ComPhoto;
import com.kh.fivechef.recipe.domain.Ingradient;
import com.kh.fivechef.recipe.domain.Like;
import com.kh.fivechef.recipe.domain.Order;
import com.kh.fivechef.recipe.domain.Recipe;
import com.kh.fivechef.recipe.domain.WhatRecipe;

public interface BoardManageService {

	// 커뮤니티 게시판 관리 코드

	public List<Community> printAllPost(int currentPage, int communityLimit);

	public Community printOneByPostNo(Integer communityNo);

	public int removeOneByPostNo(int communityNo);

	// 검색
	public int getPostTotalCount(String searchCondition, String searchValue);
	
	// 검색
	public List<Community> printAllByPostValue(String searchCondition, String searchValue, int currentPage,
			int communityLimit);

	public int modifyPost(Community community);

	public List<CReply> printAllReply(Integer refCommunityNo);

	
	////////////////////////////////////////
	
	// 레시피 게시판 관리 코드
	
	// 리스트, 검색
	public int countAllRecipe(String searchCondition, String searchValue);
	// 리스트
	public List<Recipe> printAllRecipe(int offset, int limit);
	// 상세 조회
	public Recipe printOneByNo(Integer recipeNo);
	// 상세 조회
	public List<Ingradient> printAllIng(Integer recipeNo);
	// 상세 조회
	public List<Order> printAllOrder(Integer recipeNo);
	// 상세 조회
	public List<ComPhoto> printAllComPhoto(Integer recipeNo);
	// 상세 조회
	public int checkLikeId(Like like);

	//리스트에서 관리자가 검색
	public List<Recipe> printAllByRecipeValue(String searchCondition, String searchValue, int currentPage, int recipeLimit);

	public int removeRecipe(Integer recipeNo);

	public List<SmallCategory> printSmallCat();

	public Recipe printRecipeByRNo(int recipeNo);

	public List<Ingradient> printIngByRNo(int recipeNo);

	public List<Order> printOrderByRNo(int recipeNo);

	public List<ComPhoto> printComByRNo(int recipeNo);
	
	public List<WhatRecipe> printWhat();

	public int modifyRecipe(Recipe recipe);

	public int modifyIng(Ingradient ingradient);

	public int modifyOrder(Order order);

	public int modifyCom(ComPhoto comPhoto);

}
