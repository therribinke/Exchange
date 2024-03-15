package com.example.demo.Converter;

import com.example.demo.dao.model.Exchange;
import com.example.demo.dto.ExchangeRequest;
import com.example.demo.dto.ExchangeResponse;
import lombok.experimental.UtilityClass;

import java.util.Collection;
import java.util.List;

@UtilityClass
public class ExchangeConverter {

    public static Exchange exchangeRequestConvertToExchange(ExchangeRequest exchangeRequest) {
        return new Exchange()
                .setExchangename(exchangeRequest.getExchangename())
                .setDescription(exchangeRequest.getDescription());
    }
    public static ExchangeResponse exchangeConvertToExchangeResponse(Exchange exchange) {
        return ExchangeResponse.builder()
                .id(exchange.getId())
                .exchangename(exchange.getExchangename())
                .description(exchange.getDescription())
                .build();
    }
    public static List<ExchangeResponse> exchangeCollectionConvertToList(Collection<Exchange> exchangeCollection){
        return exchangeCollection
                .stream()
                .map(ExchangeConverter::exchangeConvertToExchangeResponse)
                .toList();
    }
}
