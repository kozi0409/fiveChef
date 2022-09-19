package com.kh.fivechef.qna.service;

import java.util.List;

import com.kh.fivechef.qna.domain.QnA;

public interface QnAService {
	
	public int registQnA(QnA QnA);
	
	public int getTotalCount(String searchCondition, String searchValue);

	public List<QnA> printMyQnA(int currentPage, int qnaLimit);
}
