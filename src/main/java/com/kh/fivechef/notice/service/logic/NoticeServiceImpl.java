package com.kh.fivechef.notice.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.fivechef.notice.domain.Notice;
import com.kh.fivechef.notice.service.NoticeService;
import com.kh.fivechef.notice.store.NoticeStore;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private SqlSession session;
	
	@Autowired
	private NoticeStore nStore;
	
	@Override
	public int registerNotice(Notice notice) {
		int result = nStore.insertNotice(session, notice);
		return result;
	}
	
	@Override
	public int removeOneByNo(Integer noticeNo) {
		int result = nStore.deleteOneByNo(session, noticeNo);
		return result;
	}
	
	@Override
	public int getTotalCount(String searchCondition, String searchValue) {
		int totalCount = nStore.selectTotalCount(session, searchCondition, searchValue);
		return totalCount;
	}

	@Override
	public List<Notice> printAllNotice(int currentPage, int limit) {
		List<Notice> nList = nStore.selectAllNotice(session, currentPage, limit);
		return nList;
	}

	@Override
	public List<Notice> printAllByValue(String searchCondition, String searchValue, int currentPage, int noticeLimit) {
		List<Notice> nlist = nStore.selectAllByValue(session,searchCondition, searchValue, currentPage, noticeLimit);
		return nlist;
	}

	@Override
	public Notice printOneByNo(Integer noticeNo) {
		Notice notice = nStore.selectOneByNo(session, noticeNo);
		int result = 0;
		if(notice != null) {
			result = nStore.updateNoticeCount(session, noticeNo);
		}
		return notice;
	}


}
