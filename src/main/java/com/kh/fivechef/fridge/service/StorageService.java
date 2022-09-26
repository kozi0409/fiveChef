package com.kh.fivechef.fridge.service;

import java.util.List;

import com.kh.fivechef.fridge.domain.LargeCategory;
import com.kh.fivechef.fridge.domain.SelectBox;
import com.kh.fivechef.fridge.domain.SmallCategory;
import com.kh.fivechef.fridge.domain.Storage;

public interface StorageService {
	public List<LargeCategory> printLargeCat();
	public List<SmallCategory> printSmallCat(String largeCatId);
	public int registStorage(Storage storage);
	public List<Storage> printStorage(Integer fridgeNo);
	public int removeStorage(List<Storage> stList);
	public int registSelectValue(SelectBox selectBox);
	public int modifyStorage(Storage storage);
}
