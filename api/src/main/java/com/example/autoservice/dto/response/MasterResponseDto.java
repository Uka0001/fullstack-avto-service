package com.example.autoservice.dto.response;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MasterResponseDto {
    private Long id;
    private String fullName;
    private List<Long> completedOrderId;
}
