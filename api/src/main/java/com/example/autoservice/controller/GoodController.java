package com.example.autoservice.controller;

import com.example.autoservice.dto.mapper.request.GoodRequestMapper;
import com.example.autoservice.dto.mapper.response.GoodResponseMapper;
import com.example.autoservice.dto.request.GoodRequestDto;
import com.example.autoservice.dto.response.GoodResponseDto;
import com.example.autoservice.model.Good;
import com.example.autoservice.service.GoodService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/goods")
public class GoodController {
    private final GoodService goodService;
    private final GoodRequestMapper requestMapper;
    private final GoodResponseMapper responseMapper;

    @PostMapping
    public GoodResponseDto add(@RequestBody GoodRequestDto dto) {
        Good good = goodService.save(requestMapper.fromDto(dto));
        return responseMapper.toDto(good);
    }

    @PutMapping("/{id}")
    public GoodResponseDto update(@RequestBody GoodRequestDto dto,
                                      @PathVariable Long id) {
        Good good = requestMapper.fromDto(dto);
        good.setId(id);
        return responseMapper.toDto(goodService.save(good));
    }
}
