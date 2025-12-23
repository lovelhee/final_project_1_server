package com.ssafy.lasttable.chef.service;

import java.util.List;

import com.ssafy.lasttable.chef.entity.ChefSelection;

public interface ChefService {

	List<ChefSelection> getRandomSelections();
}
