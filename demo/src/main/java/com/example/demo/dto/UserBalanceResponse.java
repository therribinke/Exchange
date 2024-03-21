package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserBalanceResponse {
    private Long id;

    private Long valuename;
    private Float value;
}
