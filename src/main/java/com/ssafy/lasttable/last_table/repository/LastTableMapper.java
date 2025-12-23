package com.ssafy.lasttable.last_table.repository;

import com.ssafy.lasttable.last_table.entity.LastTableResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LastTableMapper {

    List<LastTableResponse> findAllAvailable();

    List<LastTableResponse> findByMenuId(@Param("menuId") Long menuId);

    List<LastTableResponse> findByUserId(@Param("userId") String userId);
}
