package com.example.autoservice.controller;

import com.example.autoservice.dto.mapper.request.CarRequestMapper;
import com.example.autoservice.dto.mapper.response.CarResponseMapper;
import com.example.autoservice.dto.request.CarRequestDto;
import com.example.autoservice.dto.response.CarResponseDto;
import com.example.autoservice.model.Car;
import com.example.autoservice.service.CarService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;
    private final CarResponseMapper carResponseMapper;
    private final CarRequestMapper carRequestMapper;

    @PostMapping
    public CarResponseDto add(@RequestBody CarRequestDto dto) {
        Car car = carService.save(carRequestMapper.fromDto(dto));
        return carResponseMapper.toDto(car);
    }

    @PutMapping("/{id}")
    public CarResponseDto update(@RequestBody CarRequestDto requestDto,
                                    @PathVariable Long id) {
        Car car = carRequestMapper.fromDto(requestDto);
        car.setId(id);
        return carResponseMapper.toDto(carService.save(car));
    }

    @GetMapping
    public List<CarResponseDto> getAll() {
        return carService.getAllCars()
                .stream()
                .map(car -> carResponseMapper.toDto(car))
                .collect(Collectors.toList());
    }
}
