package com.ssafy.lasttable.user.repository;

import com.ssafy.lasttable.user.entity.User;

import java.util.List;

public interface UserMapper {
	// 사용자 추가
	void insertUser(User user);

	// user_id로 사용자 조회
	User getUserById(String userId);

	// 모든 사용자 조회
	List<User> getAllUsers();

	// 아이디 중복 체크
	boolean checkUserIdExist(String userId);
}
