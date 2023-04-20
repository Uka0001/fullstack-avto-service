package com.example.autoservice.dto.mapper.response;

import com.example.autoservice.dto.mapper.DtoResponseMapper;
import com.example.autoservice.dto.response.CarResponseDto;
import com.example.autoservice.model.Car;
import org.springframework.stereotype.Component;

@Component
public class CarResponseMapper implements DtoResponseMapper<CarResponseDto, Car> {
    @Override
    public CarResponseDto toDto(Car car) {
        CarResponseDto responseDto = new CarResponseDto();
        responseDto.setBrand(car.getBrand());
        responseDto.setModel(car.getModel());
        responseDto.setYear(car.getYear());
        responseDto.setOwnerId(car.getOwner().getId());
        responseDto.setNumber(car.getNumber());
        responseDto.setId(car.getId());
        return responseDto;
    }
}
