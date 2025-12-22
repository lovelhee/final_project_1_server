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

	// 메뉴 추가
	@PostMapping
	public ResponseEntity<String> addMenu(@RequestBody Menu menu) {
		menuService.addMenu(menu);
		return ResponseEntity.ok("Menu added successfully");
	}

	// 메뉴 수정
	@PutMapping("/{menuId}")
	public ResponseEntity<String> updateMenu(@PathVariable("menuId") Long menuId, @RequestBody Menu menu) {
		menu.setMenuId(menuId); // 메뉴 ID 설정
		menuService.updateMenu(menu);
		return ResponseEntity.ok("Menu updated successfully");
	}

	// 메뉴 삭제
	@DeleteMapping("/{menuId}")
	public ResponseEntity<String> deleteMenu(@PathVariable("menuId") Long menuId) {
		menuService.deleteMenu(menuId);
		return ResponseEntity.ok("Menu deleted successfully");
	}
}
