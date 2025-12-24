package com.ssafy.lasttable.fcm.service;

import com.ssafy.lasttable.fcm.entity.FcmTokenRequest;

public interface FcmService {
	/**
	 * FCM 토큰 저장/업데이트
	 */
	void saveToken(FcmTokenRequest request);

	/**
	 * 주문 완료 알림 전송
	 */
	void sendOrderCompleteNotification(String userId, String orderInfo);

	/**
	 * 예약 완료 알림 전송
	 */
	void sendReservationCompleteNotification(String userId, String reservationInfo);
}