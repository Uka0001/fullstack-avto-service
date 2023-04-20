package com.example.autoservice.dto.mapper;

public interface DtoResponseMapper<D, C> {
    D toDto(C object);
}
