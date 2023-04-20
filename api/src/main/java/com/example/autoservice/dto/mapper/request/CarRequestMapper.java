package com.example.autoservice.dto.mapper.request;

import com.example.autoservice.dto.mapper.DtoRequestMapper;
import com.example.autoservice.dto.request.CarRequestDto;
import com.example.autoservice.model.Car;
import com.example.autoservice.repository.OwnerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CarRequestMapper
        implements DtoRequestMapper<CarRequestDto, Car> {
    private final OwnerRepository ownerRepository;

    @Override
    public Car fromDto(CarRequestDto dto) {
        Car car = new Car();
        car.setBrand(dto.getBrand());
        car.setModel(dto.getModel());
        car.setYear(dto.getYear());
        car.setNumber(dto.getNumber());
        car.setOwner(ownerRepository
                .findById(dto.getOwnerId())
                .orElse(null));
        return car;
    }
}
