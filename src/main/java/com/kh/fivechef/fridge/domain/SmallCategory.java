package com.kh.fivechef.fridge.domain;

public class SmallCategory {
	private String smallCatId;
	private String largeCatId;
	private String smallCatName;
	
	
	public String getSmallCatId() {
		return smallCatId;
	}
	public void setSmallCatId(String smallCatId) {
		this.smallCatId = smallCatId;
	}
	public String getLargeCatId() {
		return largeCatId;
	}
	public void setLargeCatId(String largeCatId) {
		this.largeCatId = largeCatId;
	}
	public String getSmallCatName() {
		return smallCatName;
	}
	public void setSmallCatName(String smallCatName) {
		this.smallCatName = smallCatName;
	}
	
	@Override
	public String toString() {
		return "SmallCategory [smallCatId=" + smallCatId + ", largeCatId=" + largeCatId + ", smallCatName="
				+ smallCatName + "]";
	}
	
	
}
