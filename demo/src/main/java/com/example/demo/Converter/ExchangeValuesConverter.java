package com.example.demo.Converter;

import com.example.demo.dao.model.ExchangeValue;
import com.example.demo.dto.request.ExchangeValueRequest;
import com.example.demo.dto.response.ExchangeValueResponse;
import lombok.experimental.UtilityClass;

import java.util.Collection;
import java.util.List;

@UtilityClass
public class ExchangeValuesConverter {
    public static ExchangeValue exchangesValueRequestConvertToExchangeValue(ExchangeValueRequest exchangeValueRequest, Long titleGive, Long titleReceive, Long exchangeId) {
        return new ExchangeValue()
                .setExchangeId(exchangeId)
                .setTitleGive(titleGive)
                .setTitleReceive(titleReceive)
                .setValueGive(exchangeValueRequest.getValueGive())
                .setValueReceive(exchangeValueRequest.getValueReceive());


    }

    public static ExchangeValueResponse exchangeValueConvertToExchangeValueResponse(ExchangeValue exchangeValue) {
        return ExchangeValueResponse.builder()
                .id(exchangeValue.getId())
                .exchangeId(exchangeValue.getExchangeId())
                .titleGive(exchangeValue.getTitleGive())
                .titleReceive(exchangeValue.getTitleReceive())
                .valueGive(exchangeValue.getValueGive())
                .valueReceive(exchangeValue.getValueReceive())
                .build();
    }

    public static List<ExchangeValueResponse> exchangesValuesCollectionConvertToList
            (Collection<ExchangeValue> exchangeValueCollection) {
        return exchangeValueCollection
                .stream()
                .map(ExchangeValuesConverter::exchangeValueConvertToExchangeValueResponse)
                .toList();
    }
}
