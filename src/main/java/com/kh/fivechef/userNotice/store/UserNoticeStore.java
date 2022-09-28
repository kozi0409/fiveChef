package com.kh.fivechef.userNotice.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.fivechef.notice.domain.Notice;

public interface UserNoticeStore {

	int selectTotalCount(SqlSession session, String searchCondition, String searchValue);

	List<Notice> selectAllNotice(SqlSession session, int currentPage, int limit);

	Notice selectOneByNo(SqlSession session, Integer noticeNo);

	int updateNoticeCount(SqlSession session, int noticeNo);

}
