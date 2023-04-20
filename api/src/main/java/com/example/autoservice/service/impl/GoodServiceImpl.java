package com.example.autoservice.service.impl;

import com.example.autoservice.model.Good;
import com.example.autoservice.repository.GoodRepository;
import com.example.autoservice.service.GoodService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GoodServiceImpl implements GoodService {
    private GoodRepository goodRepository;

    @Override
    public Good save(Good good) {
        return goodRepository.save(good);
    }

    @Override
    public Good update(Good good) {
        return goodRepository.save(good);
    }

    @Override
    public Good findById(Long id) {
        return goodRepository.findById(id).orElse(null);
    }
}
