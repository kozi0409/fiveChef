package com.kh.fivechef.recipe.service;

import com.kh.fivechef.recipe.domain.Ingradient;
import com.kh.fivechef.recipe.domain.Recipe;

public interface RecipeService {

	public int registerRecipe(Recipe recipe);

	public int registerIngradient(Ingradient ing);

}
