package com.example.autoservice.dto.response;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OwnerResponseDto {
    private Long id;
    private String ownerName;
    private List<Long> carsIds;
    private List<Long> ordersIds;
}
