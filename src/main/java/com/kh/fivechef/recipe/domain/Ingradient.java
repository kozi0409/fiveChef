package com.kh.fivechef.recipe.domain;

public class Ingradient {
//	private int ingNo;
//	private int recipeNo;
//	private String ingBundleName;
	private String ingAmount;
	private String largeCatId;
	private String smallCatId;
	
	
	@Override
	public String toString() {
		return "Ingradient [ingAmount=" + ingAmount + ", largeCatId=" + largeCatId + ", smallCatId=" + smallCatId + "]";
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
