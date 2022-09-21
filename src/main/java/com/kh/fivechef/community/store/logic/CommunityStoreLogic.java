package com.kh.fivechef.community.store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.fivechef.community.domain.Community;
import com.kh.fivechef.community.store.CommunityStore;


@Repository
public class CommunityStoreLogic implements CommunityStore{

	@Override
	public int insertCommunity(SqlSessionTemplate session, Community community) {
		int result = session.insert("CommunityMapper.insertCommunity", community);
		return result;
	}

	@Override
	public int selectTotalCount(SqlSessionTemplate session, String searchCondition, String searchValue) {
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("searchCondition", searchCondition);
		paramMap.put("searchValud", searchValue);
		int totalCount = session.selectOne("CommunityMapper.selectTotalCount", paramMap);
		return totalCount;
	}

	@Override
	public List<Community> selectAllCommunity(SqlSessionTemplate session, int currentPage, int communityLimit) {
		int offset = (currentPage - 1) * communityLimit;
		RowBounds rowBounds = new RowBounds(offset, communityLimit);
		List<Community> cList = session.selectList("CommunityMapper.selectAllCommunity", null, rowBounds);
		return cList;
	}
	
}
