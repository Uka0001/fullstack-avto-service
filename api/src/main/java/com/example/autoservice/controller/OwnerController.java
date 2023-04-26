package com.example.autoservice.controller;

import com.example.autoservice.dto.mapper.request.OwnerRequestMapper;
import com.example.autoservice.dto.mapper.response.OrderResponseMapper;
import com.example.autoservice.dto.mapper.response.OwnerResponseMapper;
import com.example.autoservice.dto.request.OwnerRequestDto;
import com.example.autoservice.dto.response.OrderResponseDto;
import com.example.autoservice.dto.response.OwnerResponseDto;
import com.example.autoservice.model.Owner;
import com.example.autoservice.service.OrderService;
import com.example.autoservice.service.OwnerService;
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
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/owners")
@AllArgsConstructor
public class OwnerController {
    private final OwnerService ownerService;
    private final OwnerResponseMapper ownerResponseMapper;
    private final OwnerRequestMapper ownerRequestMapper;
    private final OrderResponseMapper orderResponseMapper;
    private final OrderService orderService;

    @PostMapping
    public OwnerResponseDto add(@RequestBody OwnerRequestDto dto) {
        Owner owner = ownerService.save(ownerRequestMapper.fromDto(dto));
        return ownerResponseMapper.toDto(owner);
    }

    @PutMapping("/{id}")
    public OwnerResponseDto update(@RequestBody OwnerRequestDto requestDto,
                                   @PathVariable Long id) {
        Owner owner = ownerRequestMapper.fromDto(requestDto);
        owner.setId(id);
        ownerService.save(owner);
        return ownerResponseMapper.toDto(owner);
    }

    @GetMapping("/{id}/orders")
    public List<OrderResponseDto> getOwnerOrders(@PathVariable Long id) {
        return orderService
                .getOrdersByOwner(ownerService.getById(id))
                .stream()
                .map(orderResponseMapper::toDto)
                .toList();
    }
}
