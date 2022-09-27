package com.kh.fivechef.fridge.domain;


public class Storage {
	private int storageNo;
	private String storageName;
	private int fridgeNo;
	private String largeCatId;
	private int storageSelectNo;
	private String IngredBundle;
	
	public Storage() {}
		
	public Storage(String storageName, int fridgeNo, int storageSelectNo) {
		super();
		this.storageName = storageName;
		this.fridgeNo = fridgeNo;
		this.storageSelectNo = storageSelectNo;
	}
	
	
	public Storage(int storageNo, String storageName) {
		super();
		this.storageNo = storageNo;
		this.storageName = storageName;
	}
	
	public Storage(int storageNo, int fridgeNo, int storageSelectNo, String ingredBundle) {
		super();
		this.storageNo = storageNo;
		this.fridgeNo = fridgeNo;
		this.storageSelectNo = storageSelectNo;
		this.IngredBundle = ingredBundle;
	}

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


	public int getFridgeNo() {
		return fridgeNo;
	}


	public void setFridgeNo(int fridgeNo) {
		this.fridgeNo = fridgeNo;
	}


	public String getLargeCatId() {
		return largeCatId;
	}


	public void setLargeCatId(String largeCatId) {
		this.largeCatId = largeCatId;
	}
	
	public int getStorageSelectNo() {
		return storageSelectNo;
	}

	public void setStorageSelectNo(int storageSelectNo) {
		this.storageSelectNo = storageSelectNo;
	}
	
	public String getIngredBundle() {
		return IngredBundle;
	}

	public void setIngredBundle(String ingredBundle) {
		this.IngredBundle = ingredBundle;
	}
	
	@Override
	public String toString() {
		return "Storage [storageNo=" + storageNo + ", storageName=" + storageName + ", fridgeNo=" + fridgeNo
				+ ", largeCatId=" + largeCatId + ", storageSelectNo=" + storageSelectNo + ", IngredBundle="
				+ IngredBundle + "]";
	}

	
}
