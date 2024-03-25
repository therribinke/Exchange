package com.example.demo.dto.request;

import lombok.Data;

@Data
public class ExchangeValueRequest {

    private String exchangeId;
    private String titleGive;
    private String titleReceive;
    private Float valueGive;
    private Float valueReceive;
}
