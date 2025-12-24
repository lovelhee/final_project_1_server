package com.ssafy.lasttable.last_table.service;

import com.ssafy.lasttable.last_table.entity.LastTableResponse;
import java.util.List;

public interface LastTableService {

    List<LastTableResponse> findAll();

    List<LastTableResponse> findByMenuId(Long menuId);

    List<LastTableResponse> findByUserId(String userId);
    
    LastTableResponse findByReservationId(Long reservationId);
}
