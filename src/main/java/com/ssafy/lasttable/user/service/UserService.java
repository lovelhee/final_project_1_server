package com.ssafy.lasttable.user.service;

import com.ssafy.lasttable.user.entity.User;

import java.util.List;

public interface UserService {
	void addUser(User user);

	User getUserById(String userId);

	List<User> getAllUsers();

	boolean isUserIdDuplicated(String userId);
	
	User login(String userId, String pwd);
	
	void updateName(String userId, String newName);
}
