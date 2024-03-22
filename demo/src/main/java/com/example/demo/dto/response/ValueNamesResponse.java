package com.example.demo.dto.response;


import lombok.Builder;
import lombok.Data;



@Builder
@Data
public class ValueNamesResponse {
    private Long id;

    private String valuename;
}
