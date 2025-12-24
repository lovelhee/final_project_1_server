package com.ssafy.lasttable.fcm.entity;

public class FcmTokenRequest {
	private String userId;
	private String fcmToken;

	// 기본 생성자
	public FcmTokenRequest() {
	}

	// 전체 생성자
	public FcmTokenRequest(String userId, String fcmToken) {
		this.userId = userId;
		this.fcmToken = fcmToken;
	}

	// Getter & Setter
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFcmToken() {
		return fcmToken;
	}

	public void setFcmToken(String fcmToken) {
		this.fcmToken = fcmToken;
	}
}