package com.ssafy.lasttable.menu.service;

import com.ssafy.lasttable.menu.entity.Menu;
import com.ssafy.lasttable.menu.repository.MenuMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    private final MenuMapper menuMapper;

    public MenuServiceImpl(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

    @Override
    public List<Menu> getAllMenus() {
        return menuMapper.findAll();
    }

    @Override
    public Menu getMenuById(Long menuId) {
        return menuMapper.findById(menuId);
    }

    @Override
    public void addMenu(Menu menu) {
        menuMapper.insertMenu(menu);
    }

    @Override
    public void updateMenu(Menu menu) {
        menuMapper.updateMenu(menu);
    }

    @Override
    public void deleteMenu(Long menuId) {
        menuMapper.deleteMenu(menuId);
    }
}
