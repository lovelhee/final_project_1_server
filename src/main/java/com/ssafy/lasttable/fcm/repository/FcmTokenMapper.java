package com.ssafy.lasttable.fcm.repository;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.lasttable.fcm.entity.FcmToken;

@Mapper
public interface FcmTokenMapper {

	// userId로 토큰 조회
	FcmToken selectByUserId(String userId);

	// 토큰 저장
	int insertToken(FcmToken fcmToken);

	// 토큰 업데이트
	int updateToken(FcmToken fcmToken);

	// 토큰 삭제
	int deleteByUserId(String userId);
}