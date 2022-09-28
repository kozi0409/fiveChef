package com.kh.fivechef.boardManage.store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.fivechef.boardManage.store.BoardManageStore;
import com.kh.fivechef.community.domain.CReply;
import com.kh.fivechef.community.domain.Community;
import com.kh.fivechef.fridge.domain.SmallCategory;
import com.kh.fivechef.notice.domain.Notice;
import com.kh.fivechef.recipe.domain.ComPhoto;
import com.kh.fivechef.recipe.domain.Ingradient;
import com.kh.fivechef.recipe.domain.Like;
import com.kh.fivechef.recipe.domain.Order;
import com.kh.fivechef.recipe.domain.Recipe;
import com.kh.fivechef.recipe.domain.WhatRecipe;
@Repository
public class BoardManageStorelogic implements BoardManageStore{

	
	@Override
	public int selectPostTotalCount(SqlSession session, String searchCondition, String searchValue) {
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("searchCondition", searchCondition);
		paramMap.put("searchValue", searchValue);
		int totalCount = session.selectOne("CommunityMapper.selectPostTotalCount", paramMap);
		return totalCount;
	}

	@Override
	public List<Community> selectAllPost(SqlSession session, int currentPage, int communityLimit) {
		int offset = (currentPage - 1) * communityLimit;
		RowBounds rowBounds = new RowBounds(offset, communityLimit);
		List<Community> cList = session.selectList("CommunityMapper.selectAllPost", null, rowBounds);
		return cList;
	}

	@Override
	public Community selectOneByPostNo(SqlSession session, Integer communityNo) {
		Community community = session.selectOne("CommunityMapper.selectPostOne", communityNo);
		return community;
	}

	@Override
	public int updatePostCount(SqlSession session, int communityNo) {
		int result = session.update("CommunityMapper.updatePostCount", communityNo);
		return result;
	}

	@Override
	public int deleteOneByPostNo(SqlSession session, int communityNo) {
		int result = session.delete("CommunityMapper.deleteOneByPostNo", communityNo);
		return result;
	}


	@Override
	public List<Community> selectAllByPostValue(SqlSession session, String searchCondition, String searchValue,
			int currentPage, int communityLimit) {
		int offset = (currentPage-1) * communityLimit;
		RowBounds rowBounds = new RowBounds(offset, communityLimit);
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("searchCondition", searchCondition);
		paramMap.put("searchValue", searchValue);
		List<Community> cList = session.selectList("CommunityMapper.selectAllByPostValue", paramMap, rowBounds);
		return cList;
	}

	@Override
	public int updatePost(SqlSession session, Community community) {
		int result = session.update("CommunityMapper.updatePost", community);
		return result;
	}

	@Override
	public List<CReply> selectAllReply(SqlSession session, Integer refCommunityNo) {
		List<CReply> rList = session.selectList("CommunityMapper.selectAllReplyManage", refCommunityNo);
		return rList;
	}
	////////////////////////////////////////////////////////////////////////
	// 레시피 관리 코드
	
	// 리스트
	@Override
	public int selectCountAllRecipe(SqlSession session, String searchCondition, String searchValue) {
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("searchCondition", searchCondition);
		paramMap.put("searchValue", searchValue);
		int totalCount = session.selectOne("RecipeMapper.selectCountAllRecipe", paramMap);
		return totalCount;
	}

	// 리스트
	@Override
	public List<Recipe> selectAllRecipe(SqlSession session, int currentPage, int limit) {
		int offset = (currentPage-1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Recipe> rList = session.selectList("RecipeMapper.selectAllRecipe", null, rowBounds);
		return rList;
	}
	
	// 상세 조회
	@Override
	public Recipe selectOneByRecipeNo(SqlSession session, Integer recipeNo) {
		Recipe recipe = session.selectOne("RecipeMapper.selectOneByRecipeNo",recipeNo);
		return recipe;
	}

	
	// 상세 조회
	@Override
	public List<Ingradient> selectAllIng(SqlSession session, Integer recipeNo) {
		List<Ingradient> iList = session.selectList("RecipeMapper.selectAllIng",recipeNo);
		return iList;
	}
	
	// 상세 조회
	@Override
	public List<Order> selectAllOrder(SqlSession session, Integer recipeNo) {
		List<Order> oList = session.selectList("RecipeMapper.selectAllOrder",recipeNo);
		return oList;
	}
	
	// 상세 조회
	@Override
	public List<ComPhoto> selectAllComPhoto(SqlSession session, Integer recipeNo) {
		List<ComPhoto> cList = session.selectList("RecipeMapper.selectAllComPhoto",recipeNo);
		return cList;
	}

	@Override
	public int selectCheckLikeId(SqlSession session, Like like) {
		int result = session.selectOne("RecipeMapper.selectCheckLikeId",like);
		return result;
	}


	@Override
	public int updateBoardCount(SqlSession session, Integer recipeNo) {
		int result = session.update("RecipeMapper.updateBoardCount",recipeNo);
		return result;
	}

	@Override
	public List<WhatRecipe> selectWhatRecipe(SqlSession session) {
		List<WhatRecipe> wList = session.selectList("RecipeMapper.selectWhatRecipe");
		return wList;
	}
	
	@Override
	public List<Recipe> selectAllByRecipeValue(SqlSession session, String searchCondition, String searchValue,
			int currentPage, int recipeLimit) {
		int offset = (currentPage-1) * recipeLimit;
		RowBounds rowBounds = new RowBounds(offset, recipeLimit);
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("searchCondition", searchCondition);
		paramMap.put("searchValue", searchValue);
		List<Recipe> cList = session.selectList("RecipeMapper.selectAllByRecipeValue", paramMap, rowBounds);
		return cList;
	}
	// 재료찾기
	@Override
	public List<SmallCategory> selectAllSmallCat(SqlSession session) {
		List<SmallCategory> sList = session.selectList("RecipeMapper.selectAllSmallCat");
		return sList;
	}
	
	//modyfyview 
	@Override
	public Recipe selectRecipeByRNo(SqlSession session, int recipeNo) {
		Recipe rList = session.selectOne("RecipeMapper.selectRecipeByRNo",recipeNo);
		return rList;
	}
	
	
	@Override
	public List<Ingradient> selectIngByRNo(SqlSession session, int recipeNo) {
		List<Ingradient> iList = session.selectList("RecipeMapper.selectIngByRNo",recipeNo);
		return iList;
	}

	@Override
	public List<Order> selectOrderByRNo(SqlSession session, int recipeNo) {
		List<Order> oList = session.selectList("RecipeMapper.selectOrderByRNo",recipeNo);
		return oList;
	}

	@Override
	public List<ComPhoto> selectComByRNo(SqlSession session, int recipeNo) {
		List<ComPhoto> cList = session.selectList("RecipeMapper.selectComByRNo",recipeNo);
		return cList;
	}
	
	@Override
	public int updateRecipe(SqlSession session, Recipe recipe) {
		int result = session.update("RecipeMapper.updateRecipe",recipe);
		return result;
	}

	@Override
	public int updateIng(SqlSession session, Ingradient ingradient) {
		int result = session.update("RecipeMapper.updateIng",ingradient);
		return result;
	}

	@Override
	public int updateOrder(SqlSession session, Order order) {
//		System.out.println(order.getOrderPhotoName());
		int result;
		//order에서 사진삽입없이 데이터 넘어왔을때 사진을 제외하고 수정되도록
		if(order.getOrderPhotoName() ==null) {
			result = session.update("RecipeMapper.updateOrderNull",order);
		}else {
			result = session.update("RecipeMapper.updateOrder",order);
		}
		return result;
	}

	@Override
	public int updateCom(SqlSession session, ComPhoto comPhoto) {
		//사진수정없으면 수정x
		if(comPhoto.getComPhotoName() == null) {
			return 0;
		}
		int result = session.update("RecipeMapper.updateCom",comPhoto);
		return result;
	}
	
	@Override
	public int removeRecipeUpdate(SqlSession session, Integer recipeNo) {
		int result =session.update("RecipeMapper.removeRecipeUpdate", recipeNo);
		return result;
	}
}


