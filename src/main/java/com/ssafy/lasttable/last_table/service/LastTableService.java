package com.ssafy.lasttable.last_table.service;

import com.ssafy.lasttable.reservation.entity.Reservation;
import java.util.List;

public interface LastTableService {

    List<Reservation> findAll();

    List<Reservation> findByMenuId(Long menuId);

    List<Reservation> findByUserId(String userId);
}
