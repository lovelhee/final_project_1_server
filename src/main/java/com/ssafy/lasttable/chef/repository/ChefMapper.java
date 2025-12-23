package com.ssafy.lasttable.chef.repository;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.ssafy.lasttable.chef.entity.ChefSelection;

public interface ChefMapper {

    // 전체 재료 목록 가져오기
    @Select("SELECT * FROM chef_selection")
    List<ChefSelection> getAllSelections();
}
