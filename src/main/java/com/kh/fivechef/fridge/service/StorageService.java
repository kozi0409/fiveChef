package com.kh.fivechef.fridge.service;

import java.util.List;

import com.kh.fivechef.fridge.domain.LargeCategory;
import com.kh.fivechef.fridge.domain.SmallCategory;

public interface StorageService {
	public List<LargeCategory> printLargeCat();
	public List<SmallCategory> printSmallCat(String largeCatId);
}
