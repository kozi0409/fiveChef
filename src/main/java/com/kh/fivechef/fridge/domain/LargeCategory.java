package com.kh.fivechef.fridge.domain;

public class LargeCategory {
	private String largeCatId;
	private String largeCatName;
	
	
	public String getLargeCatId() {
		return largeCatId;
	}
	public void setLargeCatId(String largeCatId) {
		this.largeCatId = largeCatId;
	}
	public String getLargeCatName() {
		return largeCatName;
	}
	public void setLargeCatName(String largeCatName) {
		this.largeCatName = largeCatName;
	}
	
	@Override
	public String toString() {
		return "LargeCategory [largeCatId=" + largeCatId + ", largeCatName=" + largeCatName + "]";
	}
	
	
}
