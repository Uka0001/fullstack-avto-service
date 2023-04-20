package com.example.autoservice.dto.mapper.request;

import com.example.autoservice.dto.mapper.DtoRequestMapper;
import com.example.autoservice.dto.request.GoodRequestDto;
import com.example.autoservice.model.Good;
import com.example.autoservice.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GoodRequestMapper
        implements DtoRequestMapper<GoodRequestDto, Good> {
    private final OrderRepository orderRepository;

    @Override
    public Good fromDto(GoodRequestDto dto) {
        Good good = new Good();
        good.setName(dto.getName());
        good.setGoodCost(dto.getGoodCost());
        good.setOrder(orderRepository
                .findById(dto.getOrderId())
                .orElse(null));
        return good;
    }
}
