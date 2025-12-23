package com.ssafy.lasttable.reservation.service;

import com.ssafy.lasttable.reservation.entity.Reservation;
import com.ssafy.lasttable.reservation.repository.ReservationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationMapper reservationMapper;

	@Override
	@Transactional
	public Reservation addReservation(Reservation reservation) {
		// 1. 해당 시간대에 이미 예약이 있는지 확인
		boolean isDuplicate = reservationMapper.checkDuplicateReservation(reservation.getReservedAt(),
				reservation.getMenuId());

		if (isDuplicate) {
			throw new IllegalStateException("해당 시간은 이미 예약되었습니다");
		}

		// 2. user_id 존재 여부 확인
		if (reservation.getUserId() != null) {
			boolean userExists = reservationMapper.checkUserExists(reservation.getUserId());
			if (!userExists) {
				throw new IllegalArgumentException("존재하지 않는 사용자입니다");
			}
		}

		// 3. 예약 생성
		reservationMapper.insertReservation(reservation);
		return reservationMapper.findById(reservation.getReservationId());
	}

	@Override
	public List<Reservation> getAllReservations() {
		return reservationMapper.findAll();
	}

	@Override
	public Reservation cancel(Long reservationId, String canceledAt) {
		reservationMapper.cancelReservation(reservationId, canceledAt);
		return reservationMapper.findById(reservationId);
	}

	@Override
	public List<String> getAvailableTimes(String date, Long menuId) {
		// 12시부터 21시까지의 모든 시간대 생성
		List<String> allTimes = new ArrayList<>();
		for (int hour = 12; hour <= 21; hour++) {
			allTimes.add(String.format("%02d:00", hour));
		}

		// 해당 날짜에 이미 예약된 시간 조회
		List<String> reservedTimes = reservationMapper.findReservedTimesByDate(date, menuId);

		// 예약되지 않은 시간만 필터링하여 반환
		return allTimes.stream().filter(time -> !reservedTimes.contains(time)).collect(Collectors.toList());
	}

	@Override
	public List<Reservation> getLastTable() {
		return reservationMapper.findLastTable();
	}
	
	@Override
	public List<Reservation> getReservationsByUserId(String userId) {
	    // Mapper를 호출하여 DB에서 특정 사용자의 예약 목록을 가져옵니다.
	    return reservationMapper.getReservationsByUserId(userId);
	}
	

	@Override
	@Transactional
	public Reservation claim(Long reservationId, String userId) {

	    // 1. 사용자 존재 여부 체크
	    boolean userExists = reservationMapper.checkUserExists(userId);
	    if (!userExists) {
	        throw new IllegalArgumentException("존재하지 않는 사용자입니다");
	    }

	    // 2. 라스트테이블 인수 시도
	    int updated = reservationMapper.claimReservation(
	            reservationId,
	            userId
	    );

	    // 3. 업데이트 실패 = 이미 누군가 선점
	    if (updated == 0) {
	        throw new IllegalStateException("이미 다른 사용자가 예약했습니다");
	    }

	    // 4. 최신 데이터 반환
	    return reservationMapper.findById(reservationId);
	}

}