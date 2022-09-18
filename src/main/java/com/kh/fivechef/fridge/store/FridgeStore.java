package com.kh.fivechef.fridge.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.fivechef.fridge.domain.Fridge;

public interface FridgeStore {
	public int insertFridge(SqlSession session, Fridge fridge);
	public List<Fridge> selectAllFridge(SqlSession session);
}
