package com.example.demo.dto.response;


import lombok.Builder;
import lombok.Data;



@Builder
@Data
public class CurrencyResponse {
    private Long id;

    private String title;
    private String letters;
}
