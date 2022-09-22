package com.kh.fivechef.recipe.domain;

import java.sql.Date;

public class Like {
	private int recipeLikeNo;
	private int recipeNo;
	private String userId;
	private Date likeDate;
	
	@Override
	public String toString() {
		return "Like [recipeLikeNo=" + recipeLikeNo + ", recipeNo=" + recipeNo + ", userId=" + userId + ", likeDate="
				+ likeDate + "]";
	}
	public int getRecipeLikeNo() {
		return recipeLikeNo;
	}
	public void setRecipeLikeNo(int recipeLikeNo) {
		this.recipeLikeNo = recipeLikeNo;
	}
	public int getRecipeNo() {
		return recipeNo;
	}
	public void setRecipeNo(int recipeNo) {
		this.recipeNo = recipeNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getLikeDate() {
		return likeDate;
	}
	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
	}
	
	
}
