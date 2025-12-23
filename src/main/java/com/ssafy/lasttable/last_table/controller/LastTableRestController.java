package com.ssafy.lasttable.last_table.controller;

import com.ssafy.lasttable.reservation.entity.Reservation;
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

    // 1. 라스트테이블 전체 조회
    @GetMapping
    public ResponseEntity<List<Reservation>> getAll() {
        return ResponseEntity.ok(lastTableService.findAll());
    }

    // 2. 메뉴 ID로 조회
    @GetMapping("/menu/{menuId}")
    public ResponseEntity<List<Reservation>> getByMenuId(
            @PathVariable Long menuId
    ) {
        return ResponseEntity.ok(lastTableService.findByMenuId(menuId));
    }

    // 3. 유저 ID로 조회
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Reservation>> getByUserId(
            @PathVariable String userId
    ) {
        return ResponseEntity.ok(lastTableService.findByUserId(userId));
    }
}
