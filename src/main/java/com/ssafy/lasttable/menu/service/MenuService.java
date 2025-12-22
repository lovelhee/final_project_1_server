package com.ssafy.lasttable.menu.service;

import com.ssafy.lasttable.menu.entity.Menu;
import java.util.List;

public interface MenuService {
	List<Menu> getAllMenus();

	Menu getMenuById(Long menuId);

	void addMenu(Menu menu);

	void updateMenu(Menu menu);

	void deleteMenu(Long menuId);
}
