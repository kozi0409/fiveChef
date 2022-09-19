package com.kh.fivechef.recipe.domain;

public class Order {
	private int orederNo;
	private int recipeNo;
	private String recipeContents;
	private String recipePhoto;
	@Override
	public String toString() {
		return "Order [orederNo=" + orederNo + ", recipeNo=" + recipeNo + ", recipeContents=" + recipeContents
				+ ", recipePhoto=" + recipePhoto + "]";
	}
	public int getOrederNo() {
		return orederNo;
	}
	public void setOrederNo(int orederNo) {
		this.orederNo = orederNo;
	}
	public int getRecipeNo() {
		return recipeNo;
	}
	public void setRecipeNo(int recipeNo) {
		this.recipeNo = recipeNo;
	}
	public String getRecipeContents() {
		return recipeContents;
	}
	public void setRecipeContents(String recipeContents) {
		this.recipeContents = recipeContents;
	}
	public String getRecipePhoto() {
		return recipePhoto;
	}
	public void setRecipePhoto(String recipePhoto) {
		this.recipePhoto = recipePhoto;
	}
	
	
}
