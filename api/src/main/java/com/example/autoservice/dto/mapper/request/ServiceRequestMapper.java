package com.example.autoservice.dto.mapper.request;

import com.example.autoservice.dto.mapper.DtoRequestMapper;
import com.example.autoservice.dto.request.ServiceRequestDto;
import com.example.autoservice.model.Service;
import com.example.autoservice.repository.MasterRepository;
import com.example.autoservice.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ServiceRequestMapper
        implements DtoRequestMapper<ServiceRequestDto, Service> {
    private final OrderRepository orderRepository;
    private final MasterRepository masterRepository;

    @Override
    public Service fromDto(ServiceRequestDto dto) {
        Service service = new Service();
        service.setStatus(dto.getStatus());
        service.setName(dto.getName());
        service.setOrder(orderRepository
                .findById(dto.getOrderId())
                .orElse(null));
        service.setStatus(dto.getStatus());
        service.setPrice(dto.getPrice());
        service.setMaster(masterRepository
                .findById(dto.getMasterId())
                .orElse(null));
        return service;
    }
}
