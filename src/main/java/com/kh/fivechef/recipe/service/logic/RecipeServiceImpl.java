package com.kh.fivechef.recipe.service.logic;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.fivechef.recipe.domain.Ingradient;
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

}
