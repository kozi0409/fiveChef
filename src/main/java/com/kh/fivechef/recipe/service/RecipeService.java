package com.kh.fivechef.recipe.service;

import java.util.List;

import com.kh.fivechef.fridge.domain.SmallCategory;
import com.kh.fivechef.recipe.domain.ComPhoto;
import com.kh.fivechef.recipe.domain.Ingradient;
import com.kh.fivechef.recipe.domain.Like;
import com.kh.fivechef.recipe.domain.Order;
import com.kh.fivechef.recipe.domain.Recipe;
import com.kh.fivechef.recipe.domain.WhatRecipe;

public interface RecipeService {

	public int registerRecipe(Recipe recipe);

	public int registerIngradient(Ingradient ing);

	public int registerOrder(Order order);

	public int registerComPhoto(ComPhoto comPhoto);

	public List<Recipe> printAllRecipe(String whatRecipe,String listValue, int currentPage, int limit);

	public int countAllRecipe(String whatRecipe, String listValue);

	public Recipe printOneByNo(Integer recipeNo);

	public List<Ingradient> printAllIng(Integer recipeNo);

	public List<Order> printAllOrder(Integer recipeNo);

	public List<ComPhoto> printAllComPhoto(Integer recipeNo);

	public int checkLikeId(Like like);

	public int likeUp(Like like);

	public int likeDown(Like like);

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

	public int removeRecipe(Integer recipeNo);




}
