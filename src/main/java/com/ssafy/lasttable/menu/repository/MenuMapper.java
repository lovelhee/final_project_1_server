package com.ssafy.lasttable.menu.repository;

import com.ssafy.lasttable.menu.entity.Menu;

import java.util.List;

public interface MenuMapper {
	// 모든 메뉴 조회
	List<Menu> findAll();

	// 메뉴 ID로 조회
	Menu findById(Long menuId);

	// 메뉴 추가
	void insertMenu(Menu menu);

	// 메뉴 수정
	void updateMenu(Menu menu);

	// 메뉴 삭제
	void deleteMenu(Long menuId);
}
