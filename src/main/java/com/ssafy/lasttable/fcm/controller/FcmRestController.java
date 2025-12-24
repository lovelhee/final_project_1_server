package com.ssafy.lasttable.fcm.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssafy.lasttable.fcm.entity.FcmTokenRequest;
import com.ssafy.lasttable.fcm.service.FcmService;

@RestController
@RequestMapping("/api/fcm")
public class FcmRestController {

	@Autowired
	private FcmService fcmService;

	/**
	 * FCM 토큰 등록/업데이트
	 */
	@PostMapping("/token")
	public ResponseEntity<Void> updateToken(@RequestBody FcmTokenRequest request) {
		fcmService.saveToken(request);
		return ResponseEntity.ok().build();
	}
	

	@PostMapping("/order")
	public ResponseEntity<Void> triggerOrder(
	    @RequestParam String userId, 
	    @RequestParam String orderInfo 
	) {
	    fcmService.sendOrderCompleteNotification(userId, orderInfo);
	    
	    return ResponseEntity.ok().build();
	}
}