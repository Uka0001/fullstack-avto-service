package com.example.autoservice.dto.request;

import java.util.List;
import lombok.Getter;

@Getter
public class MasterRequestDto {
    private String fullName;
    private List<Long> completedOrderId;
}
