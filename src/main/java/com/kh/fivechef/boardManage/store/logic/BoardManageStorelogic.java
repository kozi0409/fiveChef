package com.kh.fivechef.boardManage.store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.fivechef.boardManage.store.BoardManageStore;
import com.kh.fivechef.community.domain.CReply;
import com.kh.fivechef.community.domain.Community;
import com.kh.fivechef.recipe.domain.ComPhoto;
import com.kh.fivechef.recipe.domain.Ingradient;
import com.kh.fivechef.recipe.domain.Like;
import com.kh.fivechef.recipe.domain.Order;
import com.kh.fivechef.recipe.domain.Recipe;
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
	public int selectCountAllRecipe(SqlSession session) {
		int count = session.selectOne("RecipeMapper.selectCountAllRecipe");
		return count;
	}

	// 리스트
	@Override
	public List<Recipe> selectAllRecipe(SqlSession session, String listValue, int currentPage, int limit) {
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("category", listValue);
		int offset=(currentPage-1)*limit;
		RowBounds rowBounds = new RowBounds(offset,limit);
		List<Recipe> rList = session.selectList("RecipeMapper.selectAllRecipe",paramMap,rowBounds);
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
}
