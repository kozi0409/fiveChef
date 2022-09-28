package com.kh.fivechef.user.service;

import java.util.List;

import com.kh.fivechef.recipe.domain.Recipe;
import com.kh.fivechef.user.domain.User;

public interface UserService {
	
	public int registerUser(User user);
	
	public User loginUser(User user);

	public User printOneUser(String userId);

	public int removeUser(String userId);

	public int modifyUser(User user);

	public User findUserId(String userEmail);

	public User findUserPwd(String userId, String userEmail);

	public List<Recipe> printMyRecipe(String userId, String listValue, int currentPage, int recipeLimit);

	public int countMyRecipe();
}
