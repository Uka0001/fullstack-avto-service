package com.example.autoservice.dto.mapper.request;

import com.example.autoservice.dto.mapper.DtoRequestMapper;
import com.example.autoservice.dto.request.OwnerRequestDto;
import com.example.autoservice.model.Owner;
import com.example.autoservice.repository.CarRepository;
import com.example.autoservice.repository.OrderRepository;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OwnerRequestMapper
        implements DtoRequestMapper<OwnerRequestDto, Owner> {
    private final CarRepository carRepository;
    private final OrderRepository orderRepository;

    @Override
    public Owner fromDto(OwnerRequestDto dto) {
        Owner owner = new Owner();
        owner.setOwnerName(dto.getOwnerName());
        owner.setCars(dto.getCarsIdList().stream()
                .map(carRepository::findById)
                .map(car -> car.orElse(null))
                .collect(Collectors.toList()));
        owner.setOrders(dto.getOrdersIdList().stream()
                .map(orderRepository::findById)
                .map(order -> order.orElse(null))
                .collect(Collectors.toList()));
        return owner;
    }
}
