package com.kh.fivechef.fridge.domain;

public class SelectBox {
	private int storageNo;
	private String largeCatId;
	private int selectBoxNo;
	
	public SelectBox() {}
	
	public SelectBox(int storageNo, String largeCatId, int selectBoxNo) {
		super();
		this.storageNo = storageNo;
		this.largeCatId = largeCatId;
		this.selectBoxNo = selectBoxNo;
	}

	public int getStorageNo() {
		return storageNo;
	}
	public void setStorageNo(int storageNo) {
		this.storageNo = storageNo;
	}
	public String getLargeCatId() {
		return largeCatId;
	}
	public void setLargeCatId(String largeCatId) {
		this.largeCatId = largeCatId;
	}
	
	public int getSelectBoxNo() {
		return selectBoxNo;
	}

	public void setSelectBoxNo(int selectBoxNo) {
		this.selectBoxNo = selectBoxNo;
	}

	@Override
	public String toString() {
		return "SelectBox [storageNo=" + storageNo + ", largeCatId=" + largeCatId + ", selectBoxNo=" + selectBoxNo
				+ "]";
	}

}
