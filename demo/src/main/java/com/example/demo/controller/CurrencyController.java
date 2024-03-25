package com.example.demo.controller;

import com.example.demo.Converter.CurrencyConverter;
import com.example.demo.dao.model.Currency;
import com.example.demo.dto.request.CurrencyRequest;
import com.example.demo.dto.response.CurrencyResponse;
import com.example.demo.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/valuename")
public class CurrencyController {
    private final CurrencyService currencyService;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<CurrencyResponse> getAllValueNames() {
        return CurrencyConverter.valueNamesCollictionToList(currencyService.getValueNames());
    }
    @GetMapping(value = "/{id}",produces = APPLICATION_JSON_VALUE)
    public CurrencyResponse getValueNames(@PathVariable Long id) {
        return CurrencyConverter.valueNamesToValueNamesResponse(currencyService.getValueName(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public CurrencyResponse addValueName(@RequestBody CurrencyRequest currencyRequest) {
        Currency addValueName = currencyService.saveValueName
                (CurrencyConverter.valueNamesRequestToValueNames(currencyRequest));
        return CurrencyConverter.valueNamesToValueNamesResponse(addValueName);
    }

    @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public CurrencyResponse addValueName(@PathVariable Long id, @RequestBody CurrencyRequest currencyRequest) {
        Currency updateValueName = currencyService.updateValueName
                (id,CurrencyConverter.valueNamesRequestToValueNames(currencyRequest));
        return CurrencyConverter.valueNamesToValueNamesResponse(updateValueName);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE)
    public void deleteValueNames(@PathVariable Long id){
        currencyService.deleteValueNames(id);
    }
}
