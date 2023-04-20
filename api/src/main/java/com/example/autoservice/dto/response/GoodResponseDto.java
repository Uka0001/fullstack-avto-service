package com.example.autoservice.dto.response;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GoodResponseDto {
    private Long id;
    private String name;
    private BigDecimal goodCost;
    private Long orderId;
}
