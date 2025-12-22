package com.ssafy.lasttable.reservation.repository;

import com.ssafy.lasttable.reservation.entity.Reservation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface ReservationMapper {
	// 예약 생성
	int insertReservation(Reservation reservation);

	// 전체 조회
	List<Reservation> findAll();

	// 예약 취소
	int cancelReservation(@Param("reservationId") Long reservationId, @Param("canceledAt") String canceledAt);

	// 라스트 테이블 조회
	List<Reservation> findLastTable();

	// ID로 단건 조회
	Reservation findById(Long reservationId);
}