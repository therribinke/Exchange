package com.example.demo.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExchangeValueResponse {
    private Long id;

    private Long exchangeId;
    private Long titleGive;
    private Long titleReceive;
    private Float valueGive;
    private Float valueReceive;
}
