package com.example.autoservice.service.impl;

import com.example.autoservice.model.Service;
import com.example.autoservice.model.ServiceStatus;
import com.example.autoservice.repository.ServiceRepository;
import com.example.autoservice.service.ServiceService;
import lombok.AllArgsConstructor;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class ServiceServiceImpl implements ServiceService {
    private ServiceRepository serviceRepository;

    @Override
    public Service save(Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public Service update(Service service, Long updatedServiceId) {
        service.setId(updatedServiceId);
        return serviceRepository.save(service);
    }

    @Override
    public Service updateByStatus(ServiceStatus status, Service service) {
        service.setStatus(status);
        return serviceRepository.save(service);
    }

    @Override
    public Service getById(Long id) {
        return serviceRepository.findById(id).orElseThrow(NoSuchFieldError::new);
    }
}
