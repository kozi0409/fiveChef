package com.kh.fivechef.postManage.service;

import java.util.List;

import com.kh.fivechef.community.domain.CReply;
import com.kh.fivechef.community.domain.Community;
import com.kh.fivechef.recipe.domain.ComPhoto;
import com.kh.fivechef.recipe.domain.Ingradient;
import com.kh.fivechef.recipe.domain.Like;
import com.kh.fivechef.recipe.domain.Order;
import com.kh.fivechef.recipe.domain.Recipe;

public interface PostManageService {

	// 커뮤니티 게시판 관리 코드
	
//	public int registPost(Community community);

	public List<Community> printAllPost(int currentPage, int communityLimit);

	public Community printOneByPostNo(Integer communityNo);

	public int removeOneByPostNo(int communityNo);

	// 검색
	public int getPostTotalCount(String searchCondition, String searchValue);
	
	// 검색
	public List<Community> printAllByPostValue(String searchCondition, String searchValue, int currentPage,
			int communityLimit);

	public int modifyPost(Community community);

	
	////////////////////////////////////////
	
	// 레시피 게시판 관리 코드
	
	// 리스트
	public int countAllRecipe();
	// 리스트
	public List<Recipe> printAllRecipe(String listValue, int currentPage, int limit);
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

}
