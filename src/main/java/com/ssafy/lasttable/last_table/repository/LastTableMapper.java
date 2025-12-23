package com.ssafy.lasttable.last_table.repository;

import com.ssafy.lasttable.reservation.entity.Reservation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LastTableMapper {

    List<Reservation> findAllAvailable();

    List<Reservation> findByMenuId(@Param("menuId") Long menuId);

    List<Reservation> findByUserId(@Param("userId") String userId);
}
