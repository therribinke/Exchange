package com.example.demo.dto;

import com.example.demo.dao.model.ValueNames;
import lombok.Data;

@Data
public class UserBalanceRequest {

    private Long valuename;
    private Float value;
}
