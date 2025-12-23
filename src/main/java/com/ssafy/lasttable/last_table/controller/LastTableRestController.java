package com.ssafy.lasttable.last_table.controller;

import com.ssafy.lasttable.last_table.entity.LastTableResponse;
import com.ssafy.lasttable.last_table.service.LastTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lasttable")
public class LastTableRestController {

    @Autowired
    private LastTableService lastTableService;

    @GetMapping
    public ResponseEntity<List<LastTableResponse>> getAll() {
        return ResponseEntity.ok(lastTableService.findAll());
    }

    @GetMapping("/menu/{menuId}")
    public ResponseEntity<List<LastTableResponse>> getByMenuId(
            @PathVariable Long menuId
    ) {
        return ResponseEntity.ok(lastTableService.findByMenuId(menuId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<LastTableResponse>> getByUserId(
            @PathVariable String userId
    ) {
        return ResponseEntity.ok(lastTableService.findByUserId(userId));
    }
}
