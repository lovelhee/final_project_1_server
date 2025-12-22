package com.ssafy.lasttable.reservation.service;

import com.ssafy.lasttable.reservation.entity.Reservation;
import com.ssafy.lasttable.reservation.repository.ReservationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationMapper reservationMapper;

	@Override
	public Reservation addReservation(Reservation reservation) {
		reservationMapper.insertReservation(reservation);
		return reservationMapper.findById(reservation.getReservationId());
	}

	@Override
	public List<Reservation> getAllReservations() {
		return reservationMapper.findAll();
	}

	@Override
	public Reservation cancel(Long reservationId, String canceledAt) {
		// 매퍼에 id와 취소시간 전달
		reservationMapper.cancelReservation(reservationId, canceledAt);
		// 취소 완료된 데이터 다시 조회해서 반환
		return reservationMapper.findById(reservationId);
	}

	@Override
	public List<Reservation> getLastTable() {
		return reservationMapper.findLastTable();
	}
}