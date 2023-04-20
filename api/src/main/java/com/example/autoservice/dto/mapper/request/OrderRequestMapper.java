package com.example.autoservice.dto.mapper.request;

import com.example.autoservice.dto.mapper.DtoRequestMapper;
import com.example.autoservice.dto.request.OrderRequestDto;
import com.example.autoservice.model.Order;
import com.example.autoservice.repository.CarRepository;
import com.example.autoservice.repository.GoodRepository;
import com.example.autoservice.repository.MasterRepository;
import com.example.autoservice.repository.ServiceRepository;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OrderRequestMapper
        implements DtoRequestMapper<OrderRequestDto, Order> {
    private final CarRepository carRepository;
    private final MasterRepository masterRepository;
    private final ServiceRepository serviceRepository;
    private final GoodRepository goodRepository;

    @Override
    public Order fromDto(OrderRequestDto dto) {
        Order order = new Order();
        order.setStatus(dto.getStatus());
        order.setCar(carRepository
                .findById(dto.getCarId())
                .orElse(null));
        order.setMaster(masterRepository
                .findById(dto.getMasterId())
                .orElse(null));
        order.setDescription(dto.getDescription());
        order.setGoodsList(dto.getGoodsIdList().stream()
                .map(goodRepository::findById)
                .map(good -> good.orElse(null))
                .collect(Collectors.toList()));
        order.setCompletionDate(dto.getCompletionDate());
        order.setServiceList(dto.getServiceIdList().stream()
                .map(serviceRepository::findById)
                .map(service -> service.orElse(null))
                .collect(Collectors.toList()));
        order.setDateOfAdoption(dto.getDateOfAdoption());
        order.setTotalCost(dto.getTotalCost());
        return order;
    }
}
