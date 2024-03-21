package com.example.demo.Converter;

import com.example.demo.dao.model.ExchangesValues;
import com.example.demo.dao.model.ValueNames;
import com.example.demo.dto.ExchangeValuesRequest;
import com.example.demo.dto.ExchangeValuesResponse;
import com.example.demo.service.ValueNamesService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.UtilityClass;

import java.util.Collection;
import java.util.List;

@UtilityClass
public class ExchangeValuesConverter {
    public static ExchangesValues exchangesValuesRequestConvertToExchangesValues(ExchangeValuesRequest exchangeValuesRequest,Long valueId1,Long valueId2) {
        return new ExchangesValues()
                .setExchangename(exchangeValuesRequest.getExchangename())
                .setValuename1(valueId1)
                .setValuename2(valueId2)
                .setValue1(exchangeValuesRequest.getValue1())
                .setValue2(exchangeValuesRequest.getValue2());
    }

    public static ExchangeValuesResponse exchangeValuesConvertToExchangeValuesResponse
            (ExchangesValues exchangesValues) {
        return ExchangeValuesResponse.builder()
                .id(exchangesValues.getId())
                .exchangename(exchangesValues.getExchangename())
                .valuename1(exchangesValues.getValuename1())
                .valuename2(exchangesValues.getValuename2())
                .value1(exchangesValues.getValue1())
                .value2(exchangesValues.getValue2())
                .build();
    }

    public static List<ExchangeValuesResponse> exchangesValuesCollectionConvertToList
            (Collection<ExchangesValues> exchangesValuesCollection) {
        return exchangesValuesCollection
                .stream()
                .map(ExchangeValuesConverter::exchangeValuesConvertToExchangeValuesResponse)
                .toList();
    }
}
