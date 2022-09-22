package com.kh.fivechef.postManage.store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.fivechef.community.domain.Community;
import com.kh.fivechef.postManage.store.PostManageStore;
@Repository
public class PostManageStorelogic implements PostManageStore{

	@Override
	public int selectTotalPostCount(SqlSessionTemplate session, String searchCondition, String searchValue) {
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("searchCondition", searchCondition);
		paramMap.put("searchValue", searchValue);
		int totalCount = session.selectOne("CommunityMapper.selectTotalPostCount", paramMap);
		return totalCount;
	}

	@Override
	public List<Community> selectAllPost(SqlSessionTemplate session, int currentPage, int communityLimit) {
		int offset = (currentPage - 1) * communityLimit;
		RowBounds rowBounds = new RowBounds(offset, communityLimit);
		List<Community> cList = session.selectList("CommunityMapper.selectAllPost", null, rowBounds);
		return cList;
	}

	@Override
	public Community selectOneByPostNo(SqlSessionTemplate session, Integer communityNo) {
		Community community = session.selectOne("CommunityMapper.selectPostOne", communityNo);
		return community;
	}

	@Override
	public int updatePostCount(SqlSessionTemplate session, Integer communityNo) {
		int result = session.update("CommunityMapper.updatePostCount", communityNo);
		return result;
	}

	@Override
	public int deleteOneByPostNo(SqlSessionTemplate session, int communityNo) {
		int result = session.delete("CommunityMapper.deleteOneByPostNo", communityNo);
		return result;
	}

}
