package com.example.autoservice.dto.request;

import com.example.autoservice.model.ServiceStatus;
import java.math.BigDecimal;
import lombok.Getter;

@Getter
public class ServiceRequestDto {
    private Long orderId;
    private String name;
    private Long masterId;
    private BigDecimal price;
    private ServiceStatus status;
}
