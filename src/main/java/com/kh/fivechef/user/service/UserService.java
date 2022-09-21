package com.kh.fivechef.user.service;

import com.kh.fivechef.user.domain.User;

public interface UserService {
	
	public int registerUser(User user);
	
	public User loginUser(User user);

	public User printOneUser(String userId);

	public int removeUser(String userId);

	public int modifyUser(User user);

	public User findUserId(String userEmail);
}
