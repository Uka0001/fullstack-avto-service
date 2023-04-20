package com.example.autoservice.dto.mapper.response;

import com.example.autoservice.dto.mapper.DtoResponseMapper;
import com.example.autoservice.dto.response.MasterResponseDto;
import com.example.autoservice.model.Master;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class MasterResponseMapper
        implements DtoResponseMapper<MasterResponseDto, Master> {
    @Override
    public MasterResponseDto toDto(Master master) {
        MasterResponseDto masterResponseDto = new MasterResponseDto();
        masterResponseDto.setCompletedOrderId(master.getCompletedOrder().stream()
                .map(order -> order.getId())
                .collect(Collectors.toList()));
        masterResponseDto.setFullName(master.getFullName());
        masterResponseDto.setId(master.getId());
        return masterResponseDto;
    }
}
