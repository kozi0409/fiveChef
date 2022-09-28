package com.kh.fivechef.userNotice.store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.fivechef.notice.domain.Notice;
import com.kh.fivechef.userNotice.store.UserNoticeStore;

@Repository
public class UserNoticeStoreLogic implements UserNoticeStore{

	@Override
	public int selectTotalCount(SqlSession session, String searchCondition, String searchValue) {
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("searchCondition", searchCondition);
		paramMap.put("searchValue", searchValue);
		int totalCount = session.selectOne("UserNoticeMapper.selectTotalCount", paramMap);
		return totalCount;
	}

	@Override
	public List<Notice> selectAllNotice(SqlSession session, int currentPage, int limit) {
		int offset = (currentPage-1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Notice> nList = session.selectList("UserNoticeMapper.selectAllNotice", null, rowBounds);
		return nList;
	}

	@Override
	public Notice selectOneByNo(SqlSession session, Integer noticeNo) {
		Notice notice = session.selectOne("UserNoticeMapper.selectOneByNo", noticeNo);
		return notice;
	}

	@Override
	public int updateNoticeCount(SqlSession session, int noticeNo) {
		int result = session.update("UserNoticeMapper.updateCount", noticeNo);
		return result;
	}

}
