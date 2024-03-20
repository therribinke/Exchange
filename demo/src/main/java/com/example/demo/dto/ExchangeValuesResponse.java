package com.example.demo.dto;

import com.example.demo.dao.model.ValueNames;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExchangeValuesResponse {
    private Long id;

    private String exchangename;
    private Long valuename1;
    private Long valuename2;
    private Float value1;
    private Float value2;
}
