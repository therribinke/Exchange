package com.example.demo.Converter;


import com.example.demo.dao.model.Currency;
import com.example.demo.dto.request.CurrencyRequest;
import com.example.demo.dto.response.CurrencyResponse;
import lombok.experimental.UtilityClass;

import java.util.Collection;
import java.util.List;

@UtilityClass
public class CurrencyConverter {

    public Currency valueNamesRequestToValueNames(CurrencyRequest currencyRequest) {
        return new Currency()
                .setTitle(currencyRequest.getTitle())
                .setLetters(currencyRequest.getLetters());
    }

    public CurrencyResponse valueNamesToValueNamesResponse(Currency currency){
        return CurrencyResponse.builder()
                .id(currency.getId())
                .title(currency.getTitle())
                .letters(currency.getLetters())
                .build();
    }

    public List<CurrencyResponse> valueNamesCollictionToList(Collection<Currency> currencyCollection){
        return currencyCollection.stream().map(CurrencyConverter::valueNamesToValueNamesResponse).toList();
    }
}
