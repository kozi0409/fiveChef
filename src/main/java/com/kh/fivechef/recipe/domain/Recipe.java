package com.kh.fivechef.recipe.domain;

import java.sql.Date;

public class Recipe {
	private int recipeNo;
	private String userId;
	private String recipeTitle;
	private String recipeIntro;
	private String rThumbnail;
	private String typeCategory;
	private String wayCategory;
	private String comPhoto1;
	private String comPhoto2;
	private String comPhoto3;
	private String comPhoto4;
	private String recipeLikeCount;
	private String recipeCount;
	//default 0으로 줘야함
	private String recipeLevel;
	private String recipeTime;
	private String recipePerson;
	private Date rCreateDate;
	@Override
	public String toString() {
		return "Recipe [recipeNo=" + recipeNo + ", userId=" + userId + ", recipeTitle=" + recipeTitle + ", recipeIntro="
				+ recipeIntro + ", rThumbnail=" + rThumbnail + ", typeCategory=" + typeCategory + ", wayCategory="
				+ wayCategory + ", comPhoto1=" + comPhoto1 + ", comPhoto2=" + comPhoto2 + ", comPhoto3=" + comPhoto3
				+ ", comPhoto4=" + comPhoto4 + ", recipeLikeCount=" + recipeLikeCount + ", recipeCount=" + recipeCount
				+ ", recipeLevel=" + recipeLevel + ", recipeTime=" + recipeTime + ", recipePerson=" + recipePerson
				+ ", rCreateDate=" + rCreateDate + "]";
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
	public String getrThumbnail() {
		return rThumbnail;
	}
	public void setrThumbnail(String rThumbnail) {
		this.rThumbnail = rThumbnail;
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
	public String getComPhoto1() {
		return comPhoto1;
	}
	public void setComPhoto1(String comPhoto1) {
		this.comPhoto1 = comPhoto1;
	}
	public String getComPhoto2() {
		return comPhoto2;
	}
	public void setComPhoto2(String comPhoto2) {
		this.comPhoto2 = comPhoto2;
	}
	public String getComPhoto3() {
		return comPhoto3;
	}
	public void setComPhoto3(String comPhoto3) {
		this.comPhoto3 = comPhoto3;
	}
	public String getComPhoto4() {
		return comPhoto4;
	}
	public void setComPhoto4(String comPhoto4) {
		this.comPhoto4 = comPhoto4;
	}
	public String getRecipeLikeCount() {
		return recipeLikeCount;
	}
	public void setRecipeLikeCount(String recipeLikeCount) {
		this.recipeLikeCount = recipeLikeCount;
	}
	public String getRecipeCount() {
		return recipeCount;
	}
	public void setRecipeCount(String recipeCount) {
		this.recipeCount = recipeCount;
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
	
	
}
