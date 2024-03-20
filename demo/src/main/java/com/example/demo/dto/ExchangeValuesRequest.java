package com.example.demo.dto;

import com.example.demo.dao.model.ValueNames;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class ExchangeValuesRequest {

    private String exchangename;
    private String valuename1;
    private String valuename2;
    private Float value1;
    private Float value2;
}
