package com.example.autoservice.dto.mapper.response;

import com.example.autoservice.dto.mapper.DtoResponseMapper;
import com.example.autoservice.dto.response.ServiceResponseDto;
import com.example.autoservice.model.Service;
import org.springframework.stereotype.Component;

@Component
public class ServiceResponseMapper
        implements DtoResponseMapper<ServiceResponseDto, Service> {
    @Override
    public ServiceResponseDto toDto(Service service) {
        ServiceResponseDto serviceResponseDto = new ServiceResponseDto();
        serviceResponseDto.setName(service.getName());
        serviceResponseDto.setStatus(service.getStatus());
        serviceResponseDto.setOrderId(service.getOrder().getId());
        serviceResponseDto.setPrice(service.getPrice());
        serviceResponseDto.setMasterId(service.getMaster().getId());
        serviceResponseDto.setId(service.getId());
        return serviceResponseDto;
    }
}
