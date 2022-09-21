package com.kh.fivechef.recipe.service;

import java.util.List;

import com.kh.fivechef.recipe.domain.ComPhoto;
import com.kh.fivechef.recipe.domain.Ingradient;
import com.kh.fivechef.recipe.domain.Order;
import com.kh.fivechef.recipe.domain.Recipe;

public interface RecipeService {

	public int registerRecipe(Recipe recipe);

	public int registerIngradient(Ingradient ing);

	public int registerOrder(Order order);

	public int registerComPhoto(ComPhoto comPhoto);

	public List<Recipe> printAllRecipe(String listValue);

	public int countAllRecipe();


}
