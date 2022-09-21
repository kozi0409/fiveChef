package com.kh.fivechef.fridge.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.fivechef.fridge.domain.LargeCategory;
import com.kh.fivechef.fridge.domain.SmallCategory;


public interface StorageStore {
	public List<LargeCategory> selectLargeCat(SqlSession session);
	public List<SmallCategory> selectSmallCat(SqlSession session, String largeCatId);
}
