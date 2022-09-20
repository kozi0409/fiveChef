package com.kh.fivechef.recipe.domain;

public class ComPhoto {
	private int comPhotoNo;
	private int recipeNo;
	private String comPhotoName;
	private String comPhotoRename;
	private String comPhotopath;
	@Override
	public String toString() {
		return "ComPhoto [comPhotoNo=" + comPhotoNo + ", recipeNo=" + recipeNo + ", comPhotoName=" + comPhotoName
				+ ", comPhotoRename=" + comPhotoRename + ", comPhotopath=" + comPhotopath + "]";
	}
	public int getComPhotoNo() {
		return comPhotoNo;
	}
	public void setComPhotoNo(int comPhotoNo) {
		this.comPhotoNo = comPhotoNo;
	}
	public int getRecipeNo() {
		return recipeNo;
	}
	public void setRecipeNo(int recipeNo) {
		this.recipeNo = recipeNo;
	}
	public String getComPhotoName() {
		return comPhotoName;
	}
	public void setComPhotoName(String comPhotoName) {
		this.comPhotoName = comPhotoName;
	}
	public String getComPhotoRename() {
		return comPhotoRename;
	}
	public void setComPhotoRename(String comPhotoRename) {
		this.comPhotoRename = comPhotoRename;
	}
	public String getComPhotopath() {
		return comPhotopath;
	}
	public void setComPhotopath(String comPhotopath) {
		this.comPhotopath = comPhotopath;
	}
	
	
	
}
