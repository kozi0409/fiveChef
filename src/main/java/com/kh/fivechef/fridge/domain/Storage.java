package com.kh.fivechef.fridge.domain;

import java.sql.Date;

public class Storage {
	private int storageNo;
	private String storageName;
	private String ingredCategory;
	private String ingredName;
	private int fridgeNo;
	private Date sCreateDate;
	private Date sUpdateDate;
	
	
	public int getStorageNo() {
		return storageNo;
	}
	public void setStorageNo(int storageNo) {
		this.storageNo = storageNo;
	}
	public String getStorageName() {
		return storageName;
	}
	public void setStorageName(String storageName) {
		this.storageName = storageName;
	}
	public String getIngredCategory() {
		return ingredCategory;
	}
	public void setIngredCategory(String ingredCategory) {
		this.ingredCategory = ingredCategory;
	}
	public String getIngredName() {
		return ingredName;
	}
	public void setIngredName(String ingredName) {
		this.ingredName = ingredName;
	}
	public int getFridgeNo() {
		return fridgeNo;
	}
	public void setFridgeNo(int fridgeNo) {
		this.fridgeNo = fridgeNo;
	}
	public Date getsCreateDate() {
		return sCreateDate;
	}
	public void setsCreateDate(Date sCreateDate) {
		this.sCreateDate = sCreateDate;
	}
	public Date getsUpdateDate() {
		return sUpdateDate;
	}
	public void setsUpdateDate(Date sUpdateDate) {
		this.sUpdateDate = sUpdateDate;
	}
	
	
	@Override
	public String toString() {
		return "Storage [storageNo=" + storageNo + ", storageName=" + storageName + ", ingredCategory=" + ingredCategory
				+ ", ingredName=" + ingredName + ", fridgeNo=" + fridgeNo + ", sCreateDate=" + sCreateDate
				+ ", sUpdateDate=" + sUpdateDate + "]";
	}
	
}
