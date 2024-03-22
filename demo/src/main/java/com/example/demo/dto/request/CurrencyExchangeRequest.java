package com.example.demo.dto.request;

import lombok.Data;

@Data
public class CurrencyExchangeRequest {
    private String exchangename;
    private String valueNameSell;
    private String valueNameBuy;
    private Float valueSell;
}
