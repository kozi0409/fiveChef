package com.kh.fivechef.fridge.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.fivechef.fridge.domain.Fridge;
import com.kh.fivechef.fridge.domain.LargeCategory;
import com.kh.fivechef.fridge.domain.SmallCategory;
import com.kh.fivechef.fridge.domain.Storage;
import com.kh.fivechef.fridge.store.StorageStore;

@Repository
public class StorageStoreLogic implements StorageStore {

	@Override
	public List<LargeCategory> selectLargeCat(SqlSession session) {
		List<LargeCategory> lList = session.selectList("FridgeMapper.selectLargeCat");
		return lList;
	}

	@Override
	public List<SmallCategory> selectSmallCat(SqlSession session, String largeCatId) {
		List<SmallCategory> sList = session.selectList("FridgeMapper.selectSmallCat", largeCatId);
		return sList;
	}

	@Override
	public int insertStorage(SqlSession session, Storage storage) {
		int result = session.insert("FridgeMapper.insertStorage", storage);
		return result;
	}

	@Override
	public List<Storage> selectStorage(SqlSession session,Integer fridgeNo) {
		List<Storage> storage = session.selectList("FridgeMapper.selectStorage", fridgeNo);
		return storage;
	}

	@Override
	public int deleteStorage(SqlSession session, List<Storage> stList) {
		int result = session.delete("FridgeMapper.deleteStorage", stList);
		return result;
	}

}
