package com.kh.fivechef.recipe.domain;

public class Ingradient {
	private int ingNo;
	private int recipeNo;
	private String ingBundleName;
	private String ingAmount;
	private String largeCatId;
	private String smallCatId;
	private String largeCatName;
	private String smallCatName;
	
	
	
	@Override
	public String toString() {
		return "Ingradient [ingNo=" + ingNo + ", recipeNo=" + recipeNo + ", ingBundleName=" + ingBundleName
				+ ", ingAmount=" + ingAmount + ", largeCatId=" + largeCatId + ", smallCatId=" + smallCatId
				+ ", largeCatName=" + largeCatName + ", smallCatName=" + smallCatName + "]";
	}
	public String getLargeCatName() {
		return largeCatName;
	}
	public void setLargeCatName(String largeCatName) {
		this.largeCatName = largeCatName;
	}
	public String getSmallCatName() {
		return smallCatName;
	}
	public void setSmallCatName(String smallCatName) {
		this.smallCatName = smallCatName;
	}
	public int getIngNo() {
		return ingNo;
	}
	public void setIngNo(int ingNo) {
		this.ingNo = ingNo;
	}
	public int getRecipeNo() {
		return recipeNo;
	}
	public void setRecipeNo(int recipeNo) {
		this.recipeNo = recipeNo;
	}
	public String getIngBundleName() {
		return ingBundleName;
	}
	public void setIngBundleName(String ingBundleName) {
		this.ingBundleName = ingBundleName;
	}
	public String getIngAmount() {
		return ingAmount;
	}
	public void setIngAmount(String ingAmount) {
		this.ingAmount = ingAmount;
	}
	public String getLargeCatId() {
		return largeCatId;
	}
	public void setLargeCatId(String largeCatId) {
		this.largeCatId = largeCatId;
	}
	public String getSmallCatId() {
		return smallCatId;
	}
	public void setSmallCatId(String smallCatId) {
		this.smallCatId = smallCatId;
	}
	
	
	
	
	
}
