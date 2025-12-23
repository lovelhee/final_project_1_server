package com.ssafy.lasttable.user.service;

import com.ssafy.lasttable.user.entity.User;
import com.ssafy.lasttable.user.repository.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	private final UserMapper userMapper;

	public UserServiceImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public void addUser(User user) {
		userMapper.insertUser(user); 
	}

	@Override
	public User getUserById(String userId) {
		return userMapper.getUserById(userId); 
	}

	@Override
	public List<User> getAllUsers() {
		return userMapper.getAllUsers(); 
	}
	
	@Override
	public boolean isUserIdDuplicated(String userId) {
	    return userMapper.checkUserIdExist(userId); // 중복된 아이디가 있으면 true
	}
	
	@Override
	public User login(String userId, String pwd) {
	    User user = userMapper.getUserById(userId);
	    if (user != null && user.getPwd().equals(pwd)) {
	        return user;
	    }
	    return null;
	}
}
