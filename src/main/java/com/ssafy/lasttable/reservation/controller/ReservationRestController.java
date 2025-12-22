package com.ssafy.lasttable.reservation.controller;

import com.ssafy.lasttable.reservation.entity.Reservation;
import com.ssafy.lasttable.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservation")
public class ReservationRestController {

	@Autowired
	private ReservationService reservationService;

	// 예약 전체 조회
	@GetMapping
	public ResponseEntity<List<Reservation>> list() {
		return ResponseEntity.ok(reservationService.getAllReservations());
	}

	// 예약 생성
	@PostMapping
	public ResponseEntity<Reservation> create(@RequestBody Reservation reservation) {
		// 클라이언트가 보낸 JSON 데이터가 reservation 객체로 자동 매핑됩니다.
		Reservation created = reservationService.addReservation(reservation);
		return ResponseEntity.ok(created);
	}

	// 예약 취소
	@PostMapping("/{reservationId}/cancel")
	public ResponseEntity<Reservation> cancel(@PathVariable("reservationId") Long reservationId,
			@RequestBody Reservation reservation) {

		// 요청 본문의 canceledAt 값을 서비스로 전달하여 상태 변경
		Reservation canceled = reservationService.cancel(reservationId, reservation.getCanceledAt());
		return ResponseEntity.ok(canceled);
	}

	// 라스트 테이블 (재판매 예약) 조회
	@GetMapping("/last-table")
	public ResponseEntity<List<Reservation>> lastTable() {
		List<Reservation> list = reservationService.getLastTable();
		return ResponseEntity.ok(list);
	}
}