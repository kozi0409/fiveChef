package com.kh.fivechef.recipe.service.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.fivechef.recipe.domain.ComPhoto;
import com.kh.fivechef.recipe.domain.Ingradient;
import com.kh.fivechef.recipe.domain.Like;
import com.kh.fivechef.recipe.domain.Order;
import com.kh.fivechef.recipe.domain.Recipe;
import com.kh.fivechef.recipe.service.RecipeService;
import com.kh.fivechef.recipe.store.RecipeStore;
@Service
public class RecipeServiceImpl implements RecipeService{
	@Autowired
	private SqlSessionTemplate session;
	@Autowired
	private RecipeStore rStore;
	
	@Override
	public int registerRecipe(Recipe recipe) {
		int result = rStore.insertRecipe(session,recipe);
		return result;
	}

	@Override
	public int registerIngradient(Ingradient ing) {
		int result = rStore.insertIngradient(session,ing);
		return result;
	}

	@Override
	public int registerOrder(Order order) {
		int result=rStore.insertOrder(session,order);
		return result;
	}

	@Override
	public int registerComPhoto(ComPhoto comPhoto) {
		int result=rStore.insertComPhoto(session,comPhoto);
		return result;
	}

	@Override
	public List<Recipe> printAllRecipe(String listValue, int currentPage, int limit) {
		List<Recipe> rList=rStore.selectAllRecipe(session, listValue,currentPage,limit);
		return rList;
	}

	@Override
	public int countAllRecipe() {
		int count = rStore.selectCountAllRecipe(session);
		return count;
	}

	@Override
	public Recipe printOneByNo(Integer recipeNo) {
		Recipe recipe = rStore.selectOneByRecipeNo(session, recipeNo);
		int result = 0;
		if(recipe != null) {
			result = rStore.updateBoardCount(session,recipeNo);
		}
		return recipe;
	}

	@Override
	public List<Ingradient> printAllIng(Integer recipeNo) {
		List<Ingradient> iList = rStore.selectAllIng(session,recipeNo);
		return iList;
	}

	@Override
	public List<Order> printAllOrder(Integer recipeNo) {
		List<Order> oList = rStore.selectAllOrder(session,recipeNo);
		return oList;
	}

	@Override
	public List<ComPhoto> printAllComPhoto(Integer recipeNo) {
		List<ComPhoto> cList = rStore.selectAllComPhoto(session,recipeNo);
		return cList;
	}

	@Override
	public int checkLikeId(Like like) {
		int result = rStore.selectCheckLikeId(session,like);
		return result;
	}

	@Override
	public int likeUp(Like like) {
		int result = rStore.insertLike(session,like);
		int result2 = rStore.updateLikeCount(session,like);
		return result;
	}

	@Override
	public int likeDown(Like like) {
		int result = rStore.deleteLike(session,like);
		int result2 = rStore.updateDLikeCount(session,like);
		return result;
	}


}
