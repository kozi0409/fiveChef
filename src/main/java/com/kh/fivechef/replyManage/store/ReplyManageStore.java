package com.kh.fivechef.replyManage.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.fivechef.community.domain.CReply;
import com.kh.fivechef.community.domain.Community;

public interface ReplyManageStore {

	public int selectTotalCommCount(SqlSession session, String searchCondition, String searchValue);

	public List<CReply> selectAllCommReply(SqlSession session, int currentPage, int replyLimit);

	public List<CReply> selectAllByCReplyValue(SqlSession session, String searchCondition, String searchValue,
			int currentPage, int replyLimit);

	public Community selectOneByCReplyNo(SqlSession session, Integer communityNo);

	public int updatePostCount(SqlSession session, int communityNo);

	public List<CReply> selectAllCReply(SqlSession session, int refCommunityNo);
	
	public int insertCReply(SqlSession session, CReply cReply);
	
	public int modifyCReply(SqlSession session, CReply cReply);
	
	public int deleteCReply(SqlSession session, Integer replyNo);
}
