package com.ssafy.lasttable.chef.controller;

import com.ssafy.lasttable.chef.entity.ChefSelection;
import com.ssafy.lasttable.chef.service.ChefService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/selection")
public class ChefRestController {

	private final ChefService service;

	public ChefRestController(ChefService cService) {
		this.service = cService;
	}
	
	@GetMapping
	public List<ChefSelection> getRandomSelections() {
		return service.getRandomSelections();
	}
}
