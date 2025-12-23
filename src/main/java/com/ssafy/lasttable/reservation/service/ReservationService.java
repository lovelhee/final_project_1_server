package com.ssafy.lasttable.reservation.service;

import com.ssafy.lasttable.reservation.entity.Reservation;
import java.util.List;

public interface ReservationService {
	Reservation addReservation(Reservation reservation);

	List<Reservation> getAllReservations();

	Reservation cancel(Long reservationId, String canceledAt);

	List<String> getAvailableTimes(String date, Long menuId);

	List<Reservation> getLastTable();
	
	List<Reservation> getReservationsByUserId(String userId);
}