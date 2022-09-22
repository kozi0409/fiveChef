package com.kh.fivechef.recipe.service;

import java.util.List;

import com.kh.fivechef.recipe.domain.ComPhoto;
import com.kh.fivechef.recipe.domain.Ingradient;
import com.kh.fivechef.recipe.domain.Like;
import com.kh.fivechef.recipe.domain.Order;
import com.kh.fivechef.recipe.domain.Recipe;

public interface RecipeService {

	public int registerRecipe(Recipe recipe);

	public int registerIngradient(Ingradient ing);

	public int registerOrder(Order order);

	public int registerComPhoto(ComPhoto comPhoto);

	public List<Recipe> printAllRecipe(String listValue, int currentPage, int limit);

	public int countAllRecipe();

	public Recipe printOneByNo(Integer recipeNo);

	public List<Ingradient> printAllIng(Integer recipeNo);

	public List<Order> printAllOrder(Integer recipeNo);

	public List<ComPhoto> printAllComPhoto(Integer recipeNo);

	public int checkLikeId(Like like);

	public int likeUp(Like like);

	public int likeDown(Like like);


}
