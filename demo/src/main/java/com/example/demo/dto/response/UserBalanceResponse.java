package com.example.demo.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserBalanceResponse {
    private Long id;

    private Long titleId;
    private Float value;
}
