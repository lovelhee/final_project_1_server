package com.ssafy.lasttable.last_table.service;

import com.ssafy.lasttable.reservation.entity.Reservation;
import com.ssafy.lasttable.last_table.repository.LastTableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LastTableServiceImpl implements LastTableService {

    @Autowired
    private LastTableMapper lastTableMapper;

    @Override
    public List<Reservation> findAll() {
        return lastTableMapper.findAllAvailable();
    }

    @Override
    public List<Reservation> findByMenuId(Long menuId) {
        return lastTableMapper.findByMenuId(menuId);
    }

    @Override
    public List<Reservation> findByUserId(String userId) {
        return lastTableMapper.findByUserId(userId);
    }
}
