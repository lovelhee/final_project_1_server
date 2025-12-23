package com.ssafy.lasttable.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssafy.lasttable.user.dto.LoginRequest;
import com.ssafy.lasttable.user.entity.User;
import com.ssafy.lasttable.user.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    
    // 로그인
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        User user = userService.login(loginRequest.getUserId(), loginRequest.getPwd());
        
        if (user != null) {
           
            String token = "generated-jwt-token-string"; 
            
            Map<String, Object> response = new HashMap<>();
            response.put("accessToken", "서버가생성한토큰"); 
            response.put("userId", user.getUserId());    
            response.put("name", user.getName());      
            response.put("phone", user.getPhone());      
            return ResponseEntity.ok(response);
            
        } else {
            return ResponseEntity.status(401).body("로그인 실패: 아이디 또는 비밀번호가 틀립니다.");
        }
    }
    
    // 이름 수정을 위한 API 추가
    @PutMapping("/{userId}/name")
    public ResponseEntity<?> updateUserName(@PathVariable String userId, @RequestBody Map<String, String> body) {
        String newName = body.get("name");
        userService.updateName(userId, newName);
        return ResponseEntity.ok("이름이 성공적으로 수정되었습니다.");
    }
}
