package com.example.autoservice.dto.mapper.request;

import com.example.autoservice.dto.mapper.DtoRequestMapper;
import com.example.autoservice.dto.request.MasterRequestDto;
import com.example.autoservice.model.Master;
import com.example.autoservice.repository.OrderRepository;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MasterRequestMapper
        implements DtoRequestMapper<MasterRequestDto, Master> {
    private final OrderRepository orderRepository;

    @Override
    public Master fromDto(MasterRequestDto dto) {
        Master master = new Master();
        master.setFullName(dto.getFullName());
        master.setCompletedOrder(dto
                .getCompletedOrderId()
                .stream()
                .map(orderRepository::findById)
                .map(order -> order.orElse(null))
                .collect(Collectors.toList()));
        return master;
    }
}
