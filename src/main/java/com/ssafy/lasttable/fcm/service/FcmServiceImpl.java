package com.ssafy.lasttable.fcm.service;

import com.google.firebase.messaging.*;
import com.ssafy.lasttable.fcm.entity.FcmToken;
import com.ssafy.lasttable.fcm.entity.FcmTokenRequest;
import com.ssafy.lasttable.fcm.repository.FcmTokenMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class FcmServiceImpl implements FcmService {
	private static final Logger log = LoggerFactory.getLogger(FcmServiceImpl.class);

	private final FcmTokenMapper fcmTokenMapper;

	public FcmServiceImpl(FcmTokenMapper fcmTokenMapper) {
		this.fcmTokenMapper = fcmTokenMapper;
	}

	@Override
	public void saveToken(FcmTokenRequest request) {

		FcmToken existing = fcmTokenMapper.selectByUserId(request.getUserId());

		FcmToken token = new FcmToken();
		token.setUserId(request.getUserId());
		token.setToken(request.getFcmToken());

		if (existing == null) {
			fcmTokenMapper.insertToken(token);
		} else {
			fcmTokenMapper.updateToken(token);
		}
	}

	@Override
	public void sendOrderCompleteNotification(String userId, String orderInfo) {
		String token = getTokenByUserId(userId);
		if (token == null) {
			return;
		}

		Map<String, String> data = new HashMap<>();
		data.put("type", "order_complete");
		data.put("orderInfo", orderInfo);

		Message message = Message.builder().setToken(token)
				.setNotification(Notification.builder().setTitle("주문 완료").setBody(orderInfo + " 주문이 접수되었습니다.").build())
				.putAllData(data)
				.setAndroidConfig(AndroidConfig.builder().setPriority(AndroidConfig.Priority.HIGH).build()).build();

		sendMessage(message, userId);
	}

	@Override
	public void sendReservationCompleteNotification(String userId, String reservationInfo) {
		String token = getTokenByUserId(userId);
		if (token == null) {
			log.warn("FCM 토큰 없음 - userId: {}", userId);
			return;
		}

		Map<String, String> data = new HashMap<>();
		data.put("type", "reservation_complete");
		data.put("reservationInfo", reservationInfo);

		Message message = Message.builder().setToken(token)
				.setNotification(
						Notification.builder().setTitle("예약 확정").setBody("예약이 확정되었습니다.\n" + reservationInfo).build())
				.putAllData(data)
				.setAndroidConfig(AndroidConfig.builder().setPriority(AndroidConfig.Priority.HIGH).build()).build();

		sendMessage(message, userId);
	}

	/**
	 * 실제 메시지 전송
	 */
	private void sendMessage(Message message, String userId) {
		try {
			String response = FirebaseMessaging.getInstance().send(message);
			log.info("FCM 전송 성공 - userId: {}, response: {}", userId, response);
		} catch (Exception e) { // FirebaseMessagingException 대신 Exception으로 잡음
			log.error("--- FCM 상세 에러 시작 ---");
			e.printStackTrace(); // 스택트레이스 전체 출력
			log.error("에러 원인(Cause): {}", e.getCause());
			log.error("--- FCM 상세 에러 끝 ---");
		}
	}

	/**
	 * userId로 FCM 토큰 조회
	 */
	private String getTokenByUserId(String userId) {
		FcmToken fcmToken = fcmTokenMapper.selectByUserId(userId);
		return fcmToken != null ? fcmToken.getToken() : null;
	}

	/**
	 * 유효하지 않은 토큰 삭제
	 */
	private void deleteInvalidToken(String userId) {
		fcmTokenMapper.deleteByUserId(userId);
		log.info("유효하지 않은 FCM 토큰 삭제 - userId: {}", userId);
	}
}