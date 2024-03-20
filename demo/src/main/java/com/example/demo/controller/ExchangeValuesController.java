package com.example.demo.controller;

import com.example.demo.Converter.ExchangeValuesConverter;
import com.example.demo.dao.model.ExchangesValues;
import com.example.demo.dao.model.ValueNames;
import com.example.demo.dto.ExchangeValuesRequest;
import com.example.demo.dto.ExchangeValuesResponse;
import com.example.demo.service.ExchangeValuesService;
import com.example.demo.service.ValueNamesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/exchangevalue")
public class ExchangeValuesController {
    private final ValueNamesService valueNamesService;
    private final ExchangeValuesService exchangeValuesService;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<ExchangeValuesResponse> getAllExchangeValues() {
        return ExchangeValuesConverter.exchangesValuesCollectionConvertToList(exchangeValuesService
                .getAllExchangeValues());
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ExchangeValuesResponse getExchangeValue(@PathVariable Long id) {

        return ExchangeValuesConverter.exchangeValuesConvertToExchangeValuesResponse
                (exchangeValuesService.getExchangeValue(id));
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ExchangeValuesResponse addExchangeValue(@RequestBody ExchangeValuesRequest exchangeValuesRequest) {
        ValueNames o1 = valueNamesService.getValueNameByValueName(exchangeValuesRequest.getValuename1());
        ValueNames o2 = valueNamesService.getValueNameByValueName(exchangeValuesRequest.getValuename2());
        ExchangesValues exchangesValues = exchangeValuesService.saveExchangeValue(ExchangeValuesConverter
                .exchangesValuesRequestConvertToExchangesValues(exchangeValuesRequest, o1.getId(), o2.getId()));
        return ExchangeValuesConverter.exchangeValuesConvertToExchangeValuesResponse(exchangesValues);
    }

    @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ExchangeValuesResponse updateExchangeValue(@PathVariable Long id, @RequestBody ExchangeValuesRequest exchangeValuesRequest) {
        ValueNames o1 = valueNamesService.getValueNameByValueName(exchangeValuesRequest.getValuename1());
        ValueNames o2 = valueNamesService.getValueNameByValueName(exchangeValuesRequest.getValuename2());
        ExchangesValues exchangesValues = exchangeValuesService.updateExchangeValue(id, ExchangeValuesConverter
                .exchangesValuesRequestConvertToExchangesValues(exchangeValuesRequest, o1.getId(), o2.getId()));
        return ExchangeValuesConverter.exchangeValuesConvertToExchangeValuesResponse(exchangesValues);
    }

    @DeleteMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE)
    public void deleteExchangeValue(@PathVariable Long id) {
        exchangeValuesService.deleteExchangeValue(id);
    }
}
