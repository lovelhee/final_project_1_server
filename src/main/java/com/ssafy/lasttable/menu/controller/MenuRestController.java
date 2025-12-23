package com.ssafy.lasttable.menu.controller;

import com.ssafy.lasttable.menu.entity.Menu;
import com.ssafy.lasttable.menu.service.MenuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menus")
public class MenuRestController {

	private final MenuService menuService;

	public MenuRestController(MenuService menuService) {
		this.menuService = menuService;
	}

	// 모든 메뉴 조회
	@GetMapping
	public ResponseEntity<List<Menu>> getAllMenus() {
		List<Menu> menus = menuService.getAllMenus();
		return ResponseEntity.ok(menus);
	}

	// 메뉴 ID로 조회
	@GetMapping("/{menuId}")
	public ResponseEntity<Menu> getMenuById(@PathVariable("menuId") Long menuId) {
		Menu menu = menuService.getMenuById(menuId);
		return menu != null ? ResponseEntity.ok(menu) : ResponseEntity.notFound().build();
	}
}
