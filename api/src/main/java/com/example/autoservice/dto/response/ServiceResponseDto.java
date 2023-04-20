package com.example.autoservice.dto.response;

import com.example.autoservice.model.ServiceStatus;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ServiceResponseDto {
    private Long id;
    private String name;
    private Long orderId;
    private Long masterId;
    private BigDecimal price;
    private ServiceStatus status;
}
