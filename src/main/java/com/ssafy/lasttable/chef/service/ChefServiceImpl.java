package com.ssafy.lasttable.chef.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.lasttable.chef.entity.ChefSelection;
import com.ssafy.lasttable.chef.repository.ChefMapper;

@Service
public class ChefServiceImpl implements ChefService {

    private final ChefMapper mapper;
    
    public ChefServiceImpl(ChefMapper cMapper) {
        this.mapper = cMapper;
    }
    
    @Override
    public List<ChefSelection> getRandomSelections() {
    	// 전체 재료 목록 가져오기
        List<ChefSelection> allSelections = mapper.getAllSelections();

        // 랜덤하게 섞기
        Collections.shuffle(allSelections);

        // 첫 8개만 선택 (중복 없이)
        return allSelections.subList(0, 8);
    }
}
