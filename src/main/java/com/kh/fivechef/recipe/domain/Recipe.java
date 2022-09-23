package com.kh.fivechef.recipe.domain;

import java.sql.Date;

public class Recipe {
	private int recipeNo;
	private String recipeTitle;
	private String recipeIntro;
	private String thumbnailName;
	private String thumbnailRename;
	private String thumbnailpath;
	private String typeCategory;
	private String wayCategory;
	private int recipeLikeCount; //인트로 바꿔
	private int recipeCount; //인트로
	//default 0으로 줘야함
	private String userId;
	private String recipeLevel;
	private String recipeTime;
	private String recipePerson;
	private Date rCreateDate;
	private String rStatus;
	@Override
	public String toString() {
		return "Recipe [recipeNo=" + recipeNo + ", recipeTitle=" + recipeTitle + ", recipeIntro=" + recipeIntro
				+ ", thumbnailName=" + thumbnailName + ", thumbnailRename=" + thumbnailRename + ", thumbnailpath="
				+ thumbnailpath + ", typeCategory=" + typeCategory + ", wayCategory=" + wayCategory
				+ ", recipeLikeCount=" + recipeLikeCount + ", recipeCount=" + recipeCount + ", userId=" + userId
				+ ", recipeLevel=" + recipeLevel + ", recipeTime=" + recipeTime + ", recipePerson=" + recipePerson
				+ ", rCreateDate=" + rCreateDate + ", rStatus=" + rStatus + "]";
	}
	public int getRecipeNo() {
		return recipeNo;
	}
	public void setRecipeNo(int recipeNo) {
		this.recipeNo = recipeNo;
	}
	public String getRecipeTitle() {
		return recipeTitle;
	}
	public void setRecipeTitle(String recipeTitle) {
		this.recipeTitle = recipeTitle;
	}
	public String getRecipeIntro() {
		return recipeIntro;
	}
	public void setRecipeIntro(String recipeIntro) {
		this.recipeIntro = recipeIntro;
	}
	public String getThumbnailName() {
		return thumbnailName;
	}
	public void setThumbnailName(String thumbnailName) {
		this.thumbnailName = thumbnailName;
	}
	public String getThumbnailRename() {
		return thumbnailRename;
	}
	public void setThumbnailRename(String thumbnailRename) {
		this.thumbnailRename = thumbnailRename;
	}
	public String getThumbnailpath() {
		return thumbnailpath;
	}
	public void setThumbnailpath(String thumbnailpath) {
		this.thumbnailpath = thumbnailpath;
	}
	public String getTypeCategory() {
		return typeCategory;
	}
	public void setTypeCategory(String typeCategory) {
		this.typeCategory = typeCategory;
	}
	public String getWayCategory() {
		return wayCategory;
	}
	public void setWayCategory(String wayCategory) {
		this.wayCategory = wayCategory;
	}
	public int getRecipeLikeCount() {
		return recipeLikeCount;
	}
	public void setRecipeLikeCount(int recipeLikeCount) {
		this.recipeLikeCount = recipeLikeCount;
	}
	public int getRecipeCount() {
		return recipeCount;
	}
	public void setRecipeCount(int recipeCount) {
		this.recipeCount = recipeCount;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRecipeLevel() {
		return recipeLevel;
	}
	public void setRecipeLevel(String recipeLevel) {
		this.recipeLevel = recipeLevel;
	}
	public String getRecipeTime() {
		return recipeTime;
	}
	public void setRecipeTime(String recipeTime) {
		this.recipeTime = recipeTime;
	}
	public String getRecipePerson() {
		return recipePerson;
	}
	public void setRecipePerson(String recipePerson) {
		this.recipePerson = recipePerson;
	}
	public Date getrCreateDate() {
		return rCreateDate;
	}
	public void setrCreateDate(Date rCreateDate) {
		this.rCreateDate = rCreateDate;
	}
	public String getrStatus() {
		return rStatus;
	}
	public void setrStatus(String rStatus) {
		this.rStatus = rStatus;
	}
	
	
	
	
}
