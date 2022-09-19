package com.kh.fivechef.fridge.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.fivechef.fridge.domain.Fridge;
import com.kh.fivechef.fridge.store.FridgeStore;

@Repository
public class FridgeStoreLogic implements FridgeStore{

	@Override
	public int insertFridge(SqlSession session, Fridge fridge) {
		int result = session.insert("FridgeMapper.insertFridge", fridge);
		return result;
	}

	@Override
	public List<Fridge> selectAllFridge(SqlSession session) {
		List<Fridge> fList = session.selectList("FridgeMapper.selectAllFridge");
		return fList;
	}

}
