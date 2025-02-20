package com.kh.fivechef.boardManage.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.fivechef.boardManage.service.BoardManageService;
import com.kh.fivechef.boardManage.store.BoardManageStore;
import com.kh.fivechef.community.domain.CReply;
import com.kh.fivechef.community.domain.Community;
import com.kh.fivechef.fridge.domain.SmallCategory;
import com.kh.fivechef.recipe.domain.ComPhoto;
import com.kh.fivechef.recipe.domain.Ingradient;
import com.kh.fivechef.recipe.domain.Like;
import com.kh.fivechef.recipe.domain.Order;
import com.kh.fivechef.recipe.domain.Recipe;
import com.kh.fivechef.recipe.domain.WhatRecipe;

@Service
public class BoardManageServiceImpl implements BoardManageService{
	
	@Autowired
	private BoardManageStore pStore;
	
	@Autowired
	private SqlSession session;
	
	@Override
	public List<Community> printAllPost(int currentPage, int communityLimit) {
		List<Community> cList = pStore.selectAllPost(session, currentPage, communityLimit);
		return cList;
	}

	@Override
	public Community printOneByPostNo(Integer communityNo) {
		Community community = pStore.selectOneByPostNo(session, communityNo);
		int result = 0;
		if(community != null) {
			result = pStore.updatePostCount(session, communityNo);
		}
		return community;
	}

	@Override
	public int removeOneByPostNo(int communityNo) {
		int result = pStore.deleteOneByPostNo(session, communityNo);
		return result;
	}

	@Override
	public int getPostTotalCount(String searchCondition, String searchValue) {
		int totalCount = pStore.selectPostTotalCount(session, searchCondition, searchValue);
		return totalCount;
	}

	@Override
	public List<Community> printAllByPostValue(String searchCondition, String searchValue, int currentPage,
			int communityLimit) {
		List<Community> clist = pStore.selectAllByPostValue(session,searchCondition, searchValue, currentPage, communityLimit);
		return clist;
	}


	@Override
	public int modifyPost(Community community) {
		int result = pStore.updatePost(session, community);
		return result;
	}
	
	@Override
	public List<CReply> printAllReply(Integer refCommunityNo) {
		List<CReply> rList = pStore.selectAllReply(session, refCommunityNo);
		return rList;
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////
	// 레시피 관리 코드
	
	// 리스트
	@Override
	public int countAllRecipe(String searchCondition, String searchValue) {
		int totalCount = pStore.selectCountAllRecipe(session, searchCondition, searchValue);
		return totalCount;
	}
	
	// 리스트
	@Override
	public List<Recipe> printAllRecipe(int currentPage, int limit) {
		List<Recipe> rList = pStore.selectAllRecipe(session,currentPage,limit);
		return rList;
	}

	// 상세 조회
	@Override
	public Recipe printOneByNo(Integer recipeNo) {
		Recipe recipe = pStore.selectOneByRecipeNo(session, recipeNo);
		int result = 0;
		if(recipe != null) {
			result = pStore.updateBoardCount(session,recipeNo);
		}
		return recipe;
	}
	
	// 상세 조회
	@Override
	public List<Ingradient> printAllIng(Integer recipeNo) {
		List<Ingradient> iList = pStore.selectAllIng(session,recipeNo);
		return iList;
	}

	// 상세 조회
	@Override
	public List<Order> printAllOrder(Integer recipeNo) {
		List<Order> oList = pStore.selectAllOrder(session,recipeNo);
		return oList;
	}

	// 상세 조회
	@Override
	public List<ComPhoto> printAllComPhoto(Integer recipeNo) {
		List<ComPhoto> cList = pStore.selectAllComPhoto(session,recipeNo);
		return cList;
	}
	// 상세 조회
	@Override
	public int checkLikeId(Like like) {
		int result = pStore.selectCheckLikeId(session,like);
		return result;
	}

	@Override
	public List<Recipe> printAllByRecipeValue(String searchCondition, String searchValue, int currentPage, int recipeLimit) {
		List<Recipe> clist = pStore.selectAllByRecipeValue(session,searchCondition, searchValue, currentPage, recipeLimit);
		return clist;
	}
	@Override
	public List<SmallCategory> printSmallCat() {
		List<SmallCategory> sList = pStore.selectAllSmallCat(session);
		return sList;
	}

	@Override
	public Recipe printRecipeByRNo(int recipeNo) {
		Recipe rList = pStore.selectRecipeByRNo(session,recipeNo);
		return rList;
	}

	@Override
	public List<Ingradient> printIngByRNo(int recipeNo) {
		List<Ingradient> iList = pStore.selectIngByRNo(session,recipeNo);
		return iList;
	}

	@Override
	public List<Order> printOrderByRNo(int recipeNo) {
		List<Order> oList = pStore.selectOrderByRNo(session,recipeNo);
		return oList;
	}

	@Override
	public List<ComPhoto> printComByRNo(int recipeNo) {
		List<ComPhoto> cList = pStore.selectComByRNo(session,recipeNo);
		return cList;
	}

	@Override
	public List<WhatRecipe> printWhat() {
		List<WhatRecipe> wList = pStore.selectWhatRecipe(session);
		return wList;
	}

	@Override
	public int modifyRecipe(Recipe recipe) {
		int result = pStore.updateRecipe(session,recipe);
		return result;
	}

	@Override
	public int modifyIng(Ingradient ingradient) {
		int result = pStore.updateIng(session,ingradient);
		return result;
	}

	@Override
	public int modifyOrder(Order order) {
		int result = pStore.updateOrder(session,order);
		return result;
	}

	@Override
	public int modifyCom(ComPhoto comPhoto) {
		int result = pStore.updateCom(session,comPhoto);
		return result;
	}
	@Override
	public int removeRecipe(Integer recipeNo) {
		int result = pStore.removeRecipeUpdate(session,recipeNo);
		return result;
	}


}
