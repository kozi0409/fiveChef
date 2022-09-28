package com.kh.fivechef.admin.service;

import java.util.List;

import com.kh.fivechef.admin.domain.Admin;
import com.kh.fivechef.community.domain.Community;
import com.kh.fivechef.qna.domain.QnA;
import com.kh.fivechef.recipe.domain.Recipe;
import com.kh.fivechef.user.domain.User;

public interface AdminService {
	//관리자
	//loginAdmin
	public Admin loginAdmin(Admin admin);
	//printOneByID
	public Admin printOneById(String adminId);
	//registerAdmin
	public int registerAdmin(Admin admin);
	//modifyAdmin
	public int modifyAdmin(Admin admin);
	//removeAdmin
	public int removeAdmin(String adminId);
	
	//master가 관리자 관리 
	//관리자 목록 출력
	public List<Admin> printAllAdmin(int currentPage, int adminLimit);
	//관리자 검색
	public int getTotalCount(String searchCondition, String searchValue);
	//관리자 삭제
	public int removeOneById(String adminId);
	
	//관리자가 회원 관리
	//회원목록 출력=>admin
	public List<User> printAllUser(int currentPage, int userLimit);
	//회원목록 페이징처리
	public int getTotalUserCount(String searchUCondition, String searchUValue);
	//관리자가 회원정보 보기
	public User printOneByUserId(String userId);
	//관리자가 회원정보 삭제
	public int removeOneByUserId(String userId);
	//관리자가 회원정보 수정
	public int modifyUser(User user);
	
	
	//관리자 검색
	public List<Admin> printAllByAdminValue(
			String searchCondition
			, String searchValue
			, int currentPage
			, int adminLimit);
	//회원 검색
	public List<User> printAllByUserValue(
			String searchCondition
			, String searchValue
			, int currentPage
			, int userLimit);
	
	//관리자 1:1문의관리
	public List<QnA> printAllQna(int currentPage, int qnaLimit);
	//1:1문의관리 페이징처리
	public int getTotalQnaCount(String searchCondition, String searchValue);
	//1:1문의관리 아이디찾기
	public QnA printOneByQna(Integer questionNo);
	public int answerQna(QnA qna);
	public List<QnA> printAllByQnaValue(String searchCondition, String searchValue, int currentPage, int qnaLimit);
	public Admin findAdminId(String adminEmail);
	public Admin findAdminPwd(String adminId, String adminEmail);
	public List<User> printNewUser();
	public List<Community> printNewCommunity();
	public List<QnA> printNewQna();
	public List<Recipe> printNewRecipe();
	
	
	


	
}
