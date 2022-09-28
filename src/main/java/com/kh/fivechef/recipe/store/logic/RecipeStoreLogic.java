package com.kh.fivechef.recipe.store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.fivechef.fridge.domain.SmallCategory;
import com.kh.fivechef.recipe.domain.ComPhoto;
import com.kh.fivechef.recipe.domain.Ingradient;
import com.kh.fivechef.recipe.domain.Like;
import com.kh.fivechef.recipe.domain.Order;
import com.kh.fivechef.recipe.domain.Recipe;
import com.kh.fivechef.recipe.domain.WhatRecipe;
import com.kh.fivechef.recipe.store.RecipeStore;
@Repository
public class RecipeStoreLogic implements RecipeStore{

	@Override
	public int insertRecipe(SqlSession session, Recipe recipe) {
		int result = session.insert("RecipeMapper.insertRecipe",recipe);
		return result;
	}

	@Override
	public int insertIngradient(SqlSession session, Ingradient ing) {
		int result = session.insert("RecipeMapper.insertIngradient",ing);
		return result;
	}

	@Override
	public int insertOrder(SqlSession session, Order order) {
		int result = session.insert("RecipeMapper.insertOrder",order);
		return result;
	}

	@Override
	public int insertComPhoto(SqlSession session, ComPhoto comPhoto) {
		int result;
		//왜 실행이 안되었는데 저장이 되는것?
//		System.out.println(comPhoto.getComPhotoName());
		if(comPhoto.getComPhotoName() == null) {
			System.out.println("실패");
			return 0;
		}else {
			result = session.insert("RecipeMapper.insertComPhoto",comPhoto);
			System.out.println("성공");
		}
		return result;
	}

	@Override
	public List<Recipe> selectAllRecipe(SqlSession session,String[] searching,String whatRecipe, String listValue, int currentPage, int limit) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("category", listValue);
		paramMap.put("whatRecipe",whatRecipe);
		paramMap.put("searching",searching);
		int offset=(currentPage-1)*limit;
		RowBounds rowBounds = new RowBounds(offset,limit);
		List<Recipe> rList = session.selectList("RecipeMapper.selectAllRecipe",paramMap,rowBounds);
		return rList;
	}

	@Override
	public int selectCountAllRecipe(SqlSession session,String[] searching,String whatRecipe, String listValue) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("category", listValue);
		paramMap.put("whatRecipe",whatRecipe);
		paramMap.put("searching",searching);
		int count = session.selectOne("RecipeMapper.selectCountAllRecipe",paramMap);
		return count;
	}

	@Override
	public Recipe selectOneByRecipeNo(SqlSession session, Integer recipeNo) {
		Recipe recipe = session.selectOne("RecipeMapper.selectOneByRecipeNo",recipeNo);
		return recipe;
	}

	@Override
	public List<Ingradient> selectAllIng(SqlSession session, Integer recipeNo) {
		List<Ingradient> iList = session.selectList("RecipeMapper.selectAllIng",recipeNo);
		return iList;
	}

	@Override
	public List<Order> selectAllOrder(SqlSession session, Integer recipeNo) {
		List<Order> oList = session.selectList("RecipeMapper.selectAllOrder",recipeNo);
		return oList;
	}

	@Override
	public List<ComPhoto> selectAllComPhoto(SqlSession session, Integer recipeNo) {
		List<ComPhoto> cList = session.selectList("RecipeMapper.selectAllComPhoto",recipeNo);
		return cList;
	}

	@Override
	public int updateBoardCount(SqlSession session, Integer recipeNo) {
		int result = session.update("RecipeMapper.updateBoardCount",recipeNo);
		return result;
	}

	@Override
	public int selectCheckLikeId(SqlSession session, Like like) {
		int result = session.selectOne("RecipeMapper.selectCheckLikeId",like);
		return result;
	}
	
	//좋아요 데이터 등록
	@Override
	public int insertLike(SqlSession session, Like like) {
		int result = session.insert("RecipeMapper.insertLike",like);
		return result;
	}
	//좋아요 카운트 업 -> 아이디당1 좋아요이기 때문에 갯수늘리기 노가다 귀찮아서 만듦
	@Override
	public int updateLikeCount(SqlSession session, Like like) {
		int result = session.update("RecipeMapper.updateLikeCount",like);
		return result;
	}
	
	//좋아요 삭제
	@Override
	public int deleteLike(SqlSession session, Like like) {
		int result = session.insert("RecipeMapper.deleteLike",like);
		return result;
	}
	//좋아요 카운트 다운
	@Override
	public int updateDLikeCount(SqlSession session, Like like) {
		int result = session.delete("RecipeMapper.updateDLikeCount",like);
		return result;
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
	public List<WhatRecipe> selectWhatRecipe(SqlSession session) {
		List<WhatRecipe> wList = session.selectList("RecipeMapper.selectWhatRecipe");
		return wList;
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
		int result =session.update("RecipeMapper.removeRecipeUpdate",recipeNo);
		return result;
	}

}
