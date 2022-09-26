package com.kh.fivechef.replyManage.store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.fivechef.community.domain.CReply;
import com.kh.fivechef.community.domain.Community;
import com.kh.fivechef.replyManage.store.ReplyManageStore;

@Repository
public class ReplyManageStorelogic implements ReplyManageStore{

	@Override
	public int selectTotalCommCount(SqlSession session, String searchCondition, String searchValue) {
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("searchCondition", searchCondition);
		paramMap.put("searchValue", searchValue);
		int totalCount = session.selectOne("ReplyMapper.selectTotalCommCount", paramMap);
		return totalCount;
	}

	@Override
	public List<CReply> selectAllCommReply(SqlSession session, int currentPage, int replyLimit) {
		int offset = (currentPage - 1) * replyLimit;
		RowBounds rowBounds = new RowBounds(offset, replyLimit);
		List<CReply> cList = session.selectList("ReplyMapper.selectAllCommReply", null, rowBounds);
		return cList;
	}

	@Override
	public List<CReply> selectAllByCReplyValue(SqlSession session, String searchCondition, String searchValue,
			int currentPage, int replyLimit) {
		int offset = (currentPage - 1) * replyLimit;
		RowBounds rowBounds = new RowBounds(offset, replyLimit);
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("searchCondition", searchCondition);
		paramMap.put("searchValue", searchValue);
		List<CReply> cList = session.selectList("ReplyMapper.selectAllByCReplyValue", paramMap, rowBounds);
		return cList;
	}

	@Override
	public Community selectOneByCReplyNo(SqlSession session, Integer communityNo) {
		Community community = session.selectOne("ReplyMapper.selectOneByCReplyNo", communityNo);
		return community;
	}

	@Override
	public int updatePostCount(SqlSession session, int communityNo) {
		int result = session.update("ReplyMapper.updatePostCount", communityNo);
		return result;
	}

	@Override
	public List<CReply> selectAllCReply(SqlSession session, int refCommunityNo) {
		List<CReply> rList = session.selectList("ReplyMapper.selectAllCReply", refCommunityNo);
		return rList;
	}

	@Override
	public int insertCReply(SqlSession session, CReply cReply) {
		int result = session.insert("ReplyMapper.insertCReply", cReply);
		return result;
	}

	@Override
	public int modifyCReply(SqlSession session, CReply cReply) {
		int result = session.update("ReplyMapper.modifyCReply", cReply);
		return result;
	}

	@Override
	public int deleteCReply(SqlSession session, Integer replyNo) {
		int result = session.delete("ReplyMapper.deleteCReply", replyNo);
		return result;
	}

	
}
