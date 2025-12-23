package com.ssafy.lasttable.reservation.repository;

import com.ssafy.lasttable.reservation.entity.Reservation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface ReservationMapper {
	void insertReservation(Reservation reservation);

	List<Reservation> findAll();

	void cancelReservation(@Param("reservationId") Long reservationId, @Param("canceledAt") String canceledAt);

	List<Reservation> findLastTable();

	Reservation findById(Long reservationId);

	List<String> findReservedTimesByDate(@Param("date") String date, @Param("menuId") Long menuId);

	// 중복 예약 체크
	boolean checkDuplicateReservation(@Param("reservedAt") String reservedAt, @Param("menuId") Long menuId);

	// 사용자 존재 여부 확인
	boolean checkUserExists(@Param("userId") String userId);
	
	List<Reservation> getReservationsByUserId(@Param("userId") String userId);
}