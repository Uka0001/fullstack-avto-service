package com.example.autoservice.controller;

import com.example.autoservice.dto.mapper.request.ServiceRequestMapper;
import com.example.autoservice.dto.mapper.response.ServiceResponseMapper;
import com.example.autoservice.dto.request.ServiceRequestDto;
import com.example.autoservice.dto.response.ServiceResponseDto;
import com.example.autoservice.model.Service;
import com.example.autoservice.model.ServiceStatus;
import com.example.autoservice.service.ServiceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/services")
public class ServiceController {
    private final ServiceService serviceService;
    private final ServiceResponseMapper responseMapper;
    private final ServiceRequestMapper requestMapper;

    @PostMapping
    public ServiceResponseDto add(@RequestBody ServiceRequestDto dto) {
        Service service = serviceService.save(requestMapper.fromDto(dto));
        return responseMapper.toDto(service);
    }

    @PutMapping("/{id}")
    public ServiceResponseDto update(@RequestBody ServiceRequestDto requestDto,
                                            @PathVariable Long id) {
        Service service = requestMapper.fromDto(requestDto);
        service.setId(id);
        return responseMapper.toDto(serviceService.save(service));
    }

    @PutMapping("/{id}/status")
    public ServiceResponseDto updateServiceStatus(@PathVariable Long id,
                                                  @RequestParam ServiceStatus updatedStatus) {
        Service service = serviceService.getById(id);
        service.setStatus(updatedStatus);
        service.setId(id);
        return responseMapper.toDto(serviceService.save(service));
    }
}
