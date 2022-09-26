package com.kh.fivechef.recipe.domain;

public class Order {
	private String orederNo;
	private int recipeNo;
	private String recipeContents;
	private String orderPhotoName;
	private String orderPhotoRename;
	private String orderPhotopath;
	@Override
	public String toString() {
		return "Order [orederNo=" + orederNo + ", recipeNo=" + recipeNo + ", recipeContents=" + recipeContents
				+ ", orderPhotoName=" + orderPhotoName + ", orderPhotoRename=" + orderPhotoRename + ", orderPhotopath="
				+ orderPhotopath + "]";
	}
	public String getOrederNo() {
		return orederNo;
	}
	public void setOrederNo(String orederNo) {
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
	public String getOrderPhotoName() {
		return orderPhotoName;
	}
	public void setOrderPhotoName(String orderPhotoName) {
		this.orderPhotoName = orderPhotoName;
	}
	public String getOrderPhotoRename() {
		return orderPhotoRename;
	}
	public void setOrderPhotoRename(String orderPhotoRename) {
		this.orderPhotoRename = orderPhotoRename;
	}
	public String getOrderPhotopath() {
		return orderPhotopath;
	}
	public void setOrderPhotopath(String orderPhotopath) {
		this.orderPhotopath = orderPhotopath;
	}
	
}
