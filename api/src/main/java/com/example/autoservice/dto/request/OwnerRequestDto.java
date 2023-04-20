package com.example.autoservice.dto.request;

import java.util.List;
import lombok.Getter;

@Getter
public class OwnerRequestDto {
    private String ownerName;
    private List<Long> carsIdList;
    private List<Long> ordersIdList;
}
