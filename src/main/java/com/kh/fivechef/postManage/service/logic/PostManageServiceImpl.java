package com.kh.fivechef.postManage.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.fivechef.community.domain.CReply;
import com.kh.fivechef.community.domain.Community;
import com.kh.fivechef.postManage.service.PostManageService;
import com.kh.fivechef.postManage.store.PostManageStore;
import com.kh.fivechef.recipe.domain.ComPhoto;
import com.kh.fivechef.recipe.domain.Ingradient;
import com.kh.fivechef.recipe.domain.Like;
import com.kh.fivechef.recipe.domain.Order;
import com.kh.fivechef.recipe.domain.Recipe;

@Service
public class PostManageServiceImpl implements PostManageService{
	
	@Autowired
	private PostManageStore pStore;
	
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
	public int countAllRecipe() {
		int count = pStore.selectCountAllRecipe(session);
		return count;
	}
	
	// 리스트
	@Override
	public List<Recipe> printAllRecipe(String listValue, int currentPage, int limit) {
		List<Recipe> rList = pStore.selectAllRecipe(session, listValue,currentPage,limit);
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



}
