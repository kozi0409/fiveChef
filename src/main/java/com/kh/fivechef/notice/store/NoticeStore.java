package com.kh.fivechef.notice.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.fivechef.notice.domain.Notice;

public interface NoticeStore {

	public int insertNotice(SqlSession session, Notice notice);

	public int selectTotalCount(SqlSession session, String searchCondition, String searchValue);

	public List<Notice> selectAllNotice(SqlSession session, int currentPage, int limit);

	public List<Notice> selectAllByValue(SqlSession session, String searchCondition, String searchValue, int currentPage, int noticeLimit);

	public int deleteOneByNo(SqlSession session, int noticeNo);

}
