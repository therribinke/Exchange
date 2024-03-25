package com.example.demo.controller;

import com.example.demo.Converter.ExchangeValuesConverter;
import com.example.demo.dao.model.ExchangeValue;
import com.example.demo.dto.request.ExchangeValueRequest;
import com.example.demo.dto.response.ExchangeValueResponse;
import com.example.demo.service.ExchangeService;
import com.example.demo.service.ExchangeValueService;
import com.example.demo.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/exchangevalue")
public class ExchangeValueController {
    private final CurrencyService currencyService;
    private final ExchangeValueService exchangeValueService;
    private final ExchangeService exchangeService;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<ExchangeValueResponse> getAllExchangeValues() {
        return ExchangeValuesConverter.exchangesValuesCollectionConvertToList(exchangeValueService
                .getAllExchangeValues());
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ExchangeValueResponse getExchangeValue(@PathVariable Long id) {

        return ExchangeValuesConverter.exchangeValueConvertToExchangeValueResponse
                (exchangeValueService.getExchangeValue(id));
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ExchangeValueResponse addExchangeValue(@RequestBody ExchangeValueRequest exchangeValueRequest) {
        var titleGive = currencyService.getValueNameByValueName(exchangeValueRequest.getTitleGive());
        var titleReceive = currencyService.getValueNameByValueName(exchangeValueRequest.getTitleReceive());
        var exchangeId = exchangeService.getExchangeByExchangeName(exchangeValueRequest.getExchangeId());
        ExchangeValue exchangeValue = exchangeValueService.saveExchangeValue(ExchangeValuesConverter
                .exchangesValueRequestConvertToExchangeValue(exchangeValueRequest, titleGive.getId(),
                        titleReceive.getId(), exchangeId.getId()));
        return ExchangeValuesConverter.exchangeValueConvertToExchangeValueResponse(exchangeValue);
    }

    @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ExchangeValueResponse updateExchangeValue(@PathVariable Long id,
                                                     @RequestBody ExchangeValueRequest exchangeValueRequest) {
        var titleGive = currencyService.getValueNameByValueName(exchangeValueRequest.getTitleGive());
        var titleReceive = currencyService.getValueNameByValueName(exchangeValueRequest.getTitleReceive());
        var exchangeId = exchangeService.getExchangeByExchangeName(exchangeValueRequest.getExchangeId());
        ExchangeValue exchangeValue = exchangeValueService.updateExchangeValue(id, ExchangeValuesConverter
                .exchangesValueRequestConvertToExchangeValue(exchangeValueRequest, titleGive.getId(),
                        titleReceive.getId(), exchangeId.getId()));
        return ExchangeValuesConverter.exchangeValueConvertToExchangeValueResponse(exchangeValue);
    }

    @DeleteMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE)
    public void deleteExchangeValue(@PathVariable Long id) {
        exchangeValueService.deleteExchangeValue(id);
    }
}
