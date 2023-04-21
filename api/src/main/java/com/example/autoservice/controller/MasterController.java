package com.example.autoservice.controller;

import com.example.autoservice.dto.mapper.request.MasterRequestMapper;
import com.example.autoservice.dto.mapper.response.MasterResponseMapper;
import com.example.autoservice.dto.mapper.response.OrderResponseMapper;
import com.example.autoservice.dto.request.MasterRequestDto;
import com.example.autoservice.dto.response.MasterResponseDto;
import com.example.autoservice.dto.response.OrderResponseDto;
import com.example.autoservice.model.Master;
import com.example.autoservice.service.MasterService;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/masters")
public class MasterController {
    private final MasterService masterService;
    private final MasterRequestMapper requestMapper;
    private final MasterResponseMapper responseMapper;
    private final OrderResponseMapper orderResponseMapper;

    @PostMapping
    public MasterResponseDto add(@RequestBody MasterRequestDto dto) {
        Master master = masterService.save(requestMapper.fromDto(dto));
        return responseMapper.toDto(master);
    }

    @PutMapping("/{id}")
    public MasterResponseDto update(@RequestBody MasterRequestDto requestDto,
                                    @PathVariable Long id) {
        Master master = requestMapper.fromDto(requestDto);
        master.setId(id);
        return responseMapper.toDto(masterService.save(master));
    }

    @GetMapping("/orders")
    public List<OrderResponseDto> findMastersOrders(@RequestParam Long masterId) {
        return masterService.getMastersOrders(masterId)
                .stream()
                .map(orderResponseMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/wages")
    public BigDecimal findMasterWages(@RequestParam Long masterId) {
        return masterService
                .getSalary(masterService.findById(masterId))
                .multiply(BigDecimal.valueOf(0.4));
    }
}
