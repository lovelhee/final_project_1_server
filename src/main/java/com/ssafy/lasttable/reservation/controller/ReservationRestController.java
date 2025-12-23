package com.ssafy.lasttable.reservation.controller;

import com.ssafy.lasttable.reservation.entity.Reservation;
import com.ssafy.lasttable.reservation.entity.ReservationCreateRequest;
import com.ssafy.lasttable.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public ResponseEntity<?> create(@RequestBody ReservationCreateRequest request) {
		try {
			Reservation reservation = new Reservation();
			reservation.setUserId(request.getUserId());
			reservation.setMenuId(request.getMenuId());
			reservation.setReservedAt(request.getReservedAt());
			reservation.setDepositAmount(request.getDepositAmount());
			reservation.setStatus("RESERVED");
			reservation.setPeopleCount(request.getPeopleCount());

			Reservation created = reservationService.addReservation(reservation);
			return ResponseEntity.ok(created);

		} catch (IllegalStateException e) {
			// 중복 예약 에러
			Map<String, String> errorResponse = new HashMap<>();
			errorResponse.put("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);

		} catch (IllegalArgumentException e) {
			// 유효하지 않은 입력 에러
			Map<String, String> errorResponse = new HashMap<>();
			errorResponse.put("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);

		} catch (Exception e) {
			// 기타 에러
			Map<String, String> errorResponse = new HashMap<>();
			errorResponse.put("error", "예약 처리 중 오류가 발생했습니다");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
		}
	}

	// 예약 취소
	@PostMapping("/{reservationId}/cancel")
	public ResponseEntity<Reservation> cancel(@PathVariable("reservationId") Long reservationId,
			@RequestBody Reservation reservation) {
		Reservation canceled = reservationService.cancel(reservationId, reservation.getCanceledAt());
		return ResponseEntity.ok(canceled);
	}

	// 특정 날짜의 예약 가능한 시간 조회
	@GetMapping("/available-times")
	public ResponseEntity<List<String>> getAvailableTimes(@RequestParam("date") String date,
			@RequestParam(value = "menuId", required = false) Long menuId) {
		List<String> availableTimes = reservationService.getAvailableTimes(date, menuId);
		return ResponseEntity.ok(availableTimes);
	}

	// 라스트 테이블 (재판매 예약) 조회
	@GetMapping("/lasttable")
	public ResponseEntity<List<Reservation>> lastTable() {
		List<Reservation> list = reservationService.getLastTable();
		return ResponseEntity.ok(list);
	}
}