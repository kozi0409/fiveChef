package com.kh.fivechef.userNotice.service;

import java.util.List;

import com.kh.fivechef.notice.domain.Notice;

public interface UserNoticeService {

	int getTotalCount(String searchCondition, String searchValue);

	List<Notice> printAllNotice(int offset, int limit);

	Notice printOneByNo(Integer noticeNo);

}
