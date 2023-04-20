package com.example.autoservice.dto.mapper.response;

import com.example.autoservice.dto.mapper.DtoResponseMapper;
import com.example.autoservice.dto.response.GoodResponseDto;
import com.example.autoservice.model.Good;
import org.springframework.stereotype.Component;

@Component
public class GoodResponseMapper implements DtoResponseMapper<GoodResponseDto, Good> {

    @Override
    public GoodResponseDto toDto(Good good) {
        GoodResponseDto responseDto = new GoodResponseDto();
        responseDto.setGoodCost(good.getGoodCost());
        responseDto.setName(good.getName());
        responseDto.setOrderId(good.getOrder().getId());
        responseDto.setId(good.getId());
        return responseDto;
    }
}
