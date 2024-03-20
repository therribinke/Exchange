package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ExchangeResponse {
    private Integer id;

    private String exchangename;
    private String description;
}
