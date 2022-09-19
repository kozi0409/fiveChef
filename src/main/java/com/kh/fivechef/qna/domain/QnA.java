package com.kh.fivechef.qna.domain;

import java.sql.Date;

public class QnA {
	private int questionNo;
	private String questionWriter;
	private String questionTitle;
	private String questionContents;
	private String qFileName;
	private String qFileReName;
	private String qFilePath;
	private String answerStatus;
	private String answerContents;
	private String answerWriter;
	private Date qEnrollDate;
	private Date qUpdateDate;
	
	
	public int getQuestionNo() {
		return questionNo;
	}
	public void setQuestionNo(int questionNo) {
		this.questionNo = questionNo;
	}
	public String getQuestionWriter() {
		return questionWriter;
	}
	public void setQuestionWriter(String questionWriter) {
		this.questionWriter = questionWriter;
	}
	public String getQuestionTitle() {
		return questionTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	public String getQuestionContents() {
		return questionContents;
	}
	public void setQuestionContents(String questionContents) {
		this.questionContents = questionContents;
	}
	public String getqFileName() {
		return qFileName;
	}
	public void setqFileName(String qFileName) {
		this.qFileName = qFileName;
	}
	public String getqFileReName() {
		return qFileReName;
	}
	public void setqFileReName(String qFileReName) {
		this.qFileReName = qFileReName;
	}
	public String getqFilePath() {
		return qFilePath;
	}
	public void setqFilePath(String qFilePath) {
		this.qFilePath = qFilePath;
	}
	public String getAnswerStatus() {
		return answerStatus;
	}
	public void setAnswerStatus(String answerStatus) {
		this.answerStatus = answerStatus;
	}
	public String getAnswerContents() {
		return answerContents;
	}
	public void setAnswerContents(String answerContents) {
		this.answerContents = answerContents;
	}
	public String getAnswerWriter() {
		return answerWriter;
	}
	public void setAnswerWriter(String answerWriter) {
		this.answerWriter = answerWriter;
	}
	public Date getqEnrollDate() {
		return qEnrollDate;
	}
	public void setqEnrollDate(Date qEnrollDate) {
		this.qEnrollDate = qEnrollDate;
	}
	public Date getqUpdateDate() {
		return qUpdateDate;
	}
	public void setqUpdateDate(Date qUpdateDate) {
		this.qUpdateDate = qUpdateDate;
	}
	
	
	@Override
	public String toString() {
		return "QnA [questionNo=" + questionNo + ", questionWriter=" + questionWriter + ", questionTitle="
				+ questionTitle + ", questionContents=" + questionContents + ", qFileName=" + qFileName
				+ ", qFileReName=" + qFileReName + ", qFilePath=" + qFilePath + ", answerStatus=" + answerStatus
				+ ", answerContents=" + answerContents + ", answerWriter=" + answerWriter + ", qEnrollDate="
				+ qEnrollDate + ", qUpdateDate=" + qUpdateDate + "]";
	}
}
