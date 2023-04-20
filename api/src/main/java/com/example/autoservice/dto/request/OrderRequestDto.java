package com.example.autoservice.dto.request;

import com.example.autoservice.model.OrderStatus;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;

@Getter
public class OrderRequestDto {
    private Long carId;
    private Long masterId;
    private String description;
    private LocalDate dateOfAdoption;
    private List<Long> serviceIdList;
    private List<Long> goodsIdList;
    private OrderStatus status;
    private BigDecimal totalCost;
    private LocalDate completionDate;
}
