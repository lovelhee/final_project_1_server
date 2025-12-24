package com.ssafy.lasttable.fcm.entity;

import java.time.LocalDateTime;

public class FcmToken {

	private Long id;
	private String userId;
	private String token;
	private LocalDateTime updatedAt;

	// 기본 생성자
	public FcmToken() {
	}

	// 전체 생성자
	public FcmToken(Long id, String userId, String token, LocalDateTime updatedAt) {
		this.id = id;
		this.userId = userId;
		this.token = token;
		this.updatedAt = updatedAt;
	}

	// Getter & Setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
}