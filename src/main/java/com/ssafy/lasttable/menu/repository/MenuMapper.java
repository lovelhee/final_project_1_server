package com.ssafy.lasttable.menu.repository;

import com.ssafy.lasttable.menu.entity.Menu;

import java.util.List;

public interface MenuMapper {
	// 모든 메뉴 조회
	List<Menu> findAll();

	// 메뉴 ID로 조회
	Menu findById(Long menuId);

}
