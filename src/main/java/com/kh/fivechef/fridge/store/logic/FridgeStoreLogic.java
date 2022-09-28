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
	public int updateFridge(SqlSession session, Fridge fridge) {
		int result = session.update("FridgeMapper.updateFridge", fridge);
		return result;
	}

	@Override
	public List<Fridge> selectAllFridge(SqlSession session, String userId) {
		List<Fridge> fList = session.selectList("FridgeMapper.selectAllFridge", userId);
		return fList;
	}

	@Override
	public int deleteOneByNo(SqlSession session, Integer fridgeNo) {
		int result = session.delete("FridgeMapper.deleteFridge", fridgeNo);
		return result;
	}

	@Override
	public Fridge selectOneByNo(SqlSession session, Integer fridgeNo) {
		Fridge fridge = session.selectOne("FridgeMapper.selectOneByFridgeNo", fridgeNo);
		return fridge;
	}



}
