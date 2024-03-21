package com.example.demo.dto;

import com.example.demo.dao.model.ValueNames;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserBalanceResponse {
    private Long id;

    private Long valuename;
    private Float value;
}
