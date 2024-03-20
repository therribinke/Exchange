package com.example.demo.Converter;


import com.example.demo.dao.model.ValueNames;
import com.example.demo.dto.ValueNamesRequest;
import com.example.demo.dto.ValueNamesResponse;
import lombok.experimental.UtilityClass;

import java.util.Collection;
import java.util.List;

@UtilityClass
public class ValueNamesConverter {

    public ValueNames valueNamesRequestToValueNames(ValueNamesRequest valueNamesRequest) {
        return new ValueNames().setValuename(valueNamesRequest.getValuename());
    }

    public ValueNamesResponse valueNamesToValueNamesResponse(ValueNames valueNames){
        return ValueNamesResponse.builder()
                .id(valueNames.getId())
                .valuename(valueNames.getValuename())
                .build();
    }

    public List<ValueNamesResponse> valueNamesCollictionToList(Collection<ValueNames> valueNamesCollection){
        return valueNamesCollection.stream().map(ValueNamesConverter::valueNamesToValueNamesResponse).toList();
    }
}
