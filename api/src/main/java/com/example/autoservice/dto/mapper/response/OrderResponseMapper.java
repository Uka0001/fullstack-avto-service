package com.example.autoservice.dto.mapper.response;

import com.example.autoservice.dto.mapper.DtoResponseMapper;
import com.example.autoservice.dto.response.OrderResponseDto;
import com.example.autoservice.model.Order;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class OrderResponseMapper
        implements DtoResponseMapper<OrderResponseDto, Order> {
    @Override
    public OrderResponseDto toDto(Order order) {
        OrderResponseDto responseDto = new OrderResponseDto();
        responseDto.setCarId(order.getCar().getId());
        responseDto.setMasterId(order.getMaster().getId());
        responseDto.setDescription(order.getDescription());
        responseDto.setStatus(order.getStatus());
        responseDto.setGoodsIdList(order.getGoodsList().stream()
                .map(o -> o.getId())
                .collect(Collectors.toList()));
        responseDto.setCompletionDate(order.getCompletionDate());
        responseDto.setDateOfAdoption(order.getDateOfAdoption());
        responseDto.setServiceIdList(order.getServiceList().stream()
                .map(o -> o.getId())
                .collect(Collectors.toList()));
        responseDto.setTotalCost(order.getTotalCost());
        responseDto.setId(order.getId());
        return responseDto;
    }
}
