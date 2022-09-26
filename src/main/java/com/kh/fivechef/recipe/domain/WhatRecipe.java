package com.kh.fivechef.recipe.domain;

public class WhatRecipe {
	private int whatNo;
	private String typeCode;
	private String typeName;
	@Override
	public String toString() {
		return "WhatRecipe [whatNo=" + whatNo + ", typeCode=" + typeCode + ", typeName=" + typeName + "]";
	}
	public int getWhatNo() {
		return whatNo;
	}
	public void setWhatNo(int whatNo) {
		this.whatNo = whatNo;
	}
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	
}
