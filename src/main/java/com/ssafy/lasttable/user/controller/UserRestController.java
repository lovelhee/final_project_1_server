package com.ssafy.lasttable.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssafy.lasttable.user.dto.LoginRequest;
import com.ssafy.lasttable.user.entity.User;
import com.ssafy.lasttable.user.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

	private final UserService userService;

	public UserRestController(UserService userService) {
		this.userService = userService;
	}

	// 사용자 추가
	@PostMapping
	public ResponseEntity<String> addUser(@RequestBody User user) {
		userService.addUser(user);
		return ResponseEntity.ok("User created successfully");
	}

	// 사용자 조회 
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable("userId") String userId) {
		User user = userService.getUserById(userId);
		return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
	}

	// 모든 사용자 조회
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userService.getAllUsers();
		return ResponseEntity.ok(users);
	}
	
	// 아이디 중복 체크
    @GetMapping("/check/{userId}")
    public ResponseEntity<String> checkUserIdDuplicated(@PathVariable("userId") String userId) {
        boolean isDuplicated = userService.isUserIdDuplicated(userId);
        return isDuplicated ? ResponseEntity.status(400).body("User ID is already taken") 
                            : ResponseEntity.ok("User ID is available");
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) { // User 대신 LoginRequest 사용
        User user = userService.login(loginRequest.getUserId(), loginRequest.getPwd());
        
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(401).body("아이디 또는 비밀번호가 틀렸습니다.");
        }
    }
}
