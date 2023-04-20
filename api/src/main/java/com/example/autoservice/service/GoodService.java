package com.example.autoservice.service;

import com.example.autoservice.model.Good;

public interface GoodService {

    Good save(Good good);

    Good update(Good good);
    
    Good findById(Long id);
}
