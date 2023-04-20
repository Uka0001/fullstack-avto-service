package com.example.autoservice.service;

import com.example.autoservice.model.Service;
import com.example.autoservice.model.ServiceStatus;

public interface ServiceService {

    Service save(Service service);

    Service update(Service service, Long updatedServiceId);

    Service updateByStatus(ServiceStatus status, Service service);

    Service getById(Long id);
}
