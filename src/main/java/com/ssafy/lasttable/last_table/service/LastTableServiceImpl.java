package com.ssafy.lasttable.last_table.service;

import com.ssafy.lasttable.reservation.entity.Reservation;
import com.ssafy.lasttable.last_table.entity.LastTableResponse;
import com.ssafy.lasttable.last_table.repository.LastTableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LastTableServiceImpl implements LastTableService {

    @Autowired
    private LastTableMapper lastTableMapper;

    @Override
    public List<LastTableResponse> findAll() {
        return lastTableMapper.findAllAvailable();
    }

    @Override
    public List<LastTableResponse> findByMenuId(Long menuId) {
        return lastTableMapper.findByMenuId(menuId);
    }

    @Override
    public List<LastTableResponse> findByUserId(String userId) {
        return lastTableMapper.findByUserId(userId);
    }

	@Override
	public LastTableResponse findByReservationId(Long reservationId) {
		return lastTableMapper.findByReservationId(reservationId);
	}
}
