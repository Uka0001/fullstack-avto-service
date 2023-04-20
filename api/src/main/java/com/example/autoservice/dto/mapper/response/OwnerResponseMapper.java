package com.example.autoservice.dto.mapper.response;

import com.example.autoservice.dto.mapper.DtoResponseMapper;
import com.example.autoservice.dto.response.OwnerResponseDto;
import com.example.autoservice.model.Owner;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class OwnerResponseMapper
        implements DtoResponseMapper<OwnerResponseDto, Owner> {
    @Override
    public OwnerResponseDto toDto(Owner owner) {
        OwnerResponseDto responseDto = new OwnerResponseDto();
        responseDto.setOwnerName(owner.getOwnerName());
        responseDto.setCarsId(owner.getCars().stream()
                .map(car -> car.getId())
                .collect(Collectors.toList()));
        responseDto.setOrdersId(owner.getOrders().stream()
                .map(car -> car.getId())
                .collect(Collectors.toList()));
        responseDto.setId(owner.getId());
        return responseDto;
    }
}
