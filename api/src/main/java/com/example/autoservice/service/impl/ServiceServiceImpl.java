package com.example.autoservice.service.impl;

import com.example.autoservice.model.Service;
import com.example.autoservice.model.ServiceStatus;
import com.example.autoservice.repository.ServiceRepository;
import com.example.autoservice.service.ServiceService;
import lombok.AllArgsConstructor;

import java.util.NoSuchElementException;
import java.util.Optional;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class ServiceServiceImpl implements ServiceService {
    private final ServiceRepository serviceRepository;

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
    public Service updateByStatus(Long id, ServiceStatus status) {
        Optional<Service> optionalService = Optional.of(serviceRepository.findById(id).orElseThrow());
        Service service = optionalService.get();
        service.setStatus(status);
        return serviceRepository.save(service);
    }

    @Override
    public Service getById(Long id) {
        return serviceRepository.findById(id).orElseThrow(NoSuchFieldError::new);
    }
}
