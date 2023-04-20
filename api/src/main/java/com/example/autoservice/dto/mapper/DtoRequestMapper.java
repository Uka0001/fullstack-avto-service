package com.example.autoservice.dto.mapper;

public interface DtoRequestMapper<D, C> {
    C fromDto(D dto);
}
