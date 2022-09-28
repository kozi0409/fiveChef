package com.kh.fivechef.userNotice.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.fivechef.notice.domain.Notice;
import com.kh.fivechef.userNotice.service.UserNoticeService;
import com.kh.fivechef.userNotice.store.UserNoticeStore;

@Service
public class UserNoticeServiceImpl implements UserNoticeService{
	@Autowired
	private SqlSession session;
	
	@Autowired
	private UserNoticeStore unStore;

	@Override
	public int getTotalCount(String searchCondition, String searchValue) {
		int totalCount = unStore.selectTotalCount(session, searchCondition, searchValue);
		return totalCount;
	}

	@Override
	public List<Notice> printAllNotice(int currentPage, int limit) {
		List<Notice> nList = unStore.selectAllNotice(session, currentPage, limit);
		return nList;
	}

	@Override
	public Notice printOneByNo(Integer noticeNo) {
		Notice notice = unStore.selectOneByNo(session, noticeNo);
		int result = 0;
		if(notice != null) {
			result = unStore.updateNoticeCount(session, noticeNo);
		}
		return notice;
	}

}
