package com.kh.fivechef.recipe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kh.fivechef.recipe.domain.Ingradient;
import com.kh.fivechef.recipe.domain.Recipe;
import com.kh.fivechef.recipe.service.RecipeService;

@Controller
public class RecipeController {
	@Autowired
	private RecipeService rService;
	
	@RequestMapping(value="/recipe/writeView.kh", method = RequestMethod.GET)
	public String showRecipeWrite() {
		return "recipe/recipeWriteForm";
	}
	
	@RequestMapping(value="/recipe/recipeRegister.kh" , method= RequestMethod.POST)
	public ModelAndView recipeRegist(
			ModelAndView mv
			,@ModelAttribute Recipe recipe
			,@ModelAttribute Ingradient ing) {
		
			
			
//			System.out.println(ing);
//			System.out.println(iList);
//			for(int i = 0 ; i< ing.getIngAmount().split(",").length; ++i) {
//				System.out.println(ing.getIngAmount().split(",")[i]);
//			}
			
			
		try {
			int result = rService.registerRecipe(recipe);
			
			List<Ingradient> iList = new ArrayList<Ingradient>();
			for(int i = 0; i<ing.getIngAmount().split(",").length;i++) {
				Ingradient ingredient = new Ingradient();
				ingredient.setIngAmount(ing.getIngAmount().split(",")[i]);
				ingredient.setLargeCatId(ing.getLargeCatId().split(",")[i]);
				ingredient.setSmallCatId(ing.getSmallCatId().split(",")[i]);
				iList.add(ingredient);
			}
			System.out.println(iList.get(0));
			
			
			mv.setViewName("recipe/recipeWriteForm");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return mv;
	}
}
