package com.kh.fivechef.notice.service;

import java.util.List;

import com.kh.fivechef.notice.domain.Notice;

public interface NoticeService {
	
	public int registerNotice(Notice notice);

	public int modifyNotice(Notice notice);

	public int removeOneByNo(Integer noticeNo);
	
	public int getTotalCount(String searchCondition, String searchValue);

	public List<Notice> printAllNotice(int offset, int limit);

	public List<Notice> printAllByValue(String searchCondition, String searchValue, int currentPage, int noticeLimit);

	public Notice printOneByNo(Integer noticeNo);


}
