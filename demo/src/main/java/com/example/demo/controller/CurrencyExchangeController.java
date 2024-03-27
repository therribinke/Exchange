package com.example.demo.controller;

import com.example.demo.dto.request.CurrencyExchangeRequest;
import com.example.demo.service.CurrencyExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/balance")
public class CurrencyExchangeController {
    private final CurrencyExchangeService currencyExchangeService;

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping(value = "/user/{idUser}/currencyexchange", consumes = APPLICATION_JSON_VALUE)
    public void exchangeUserValue(@PathVariable Long idUser, @RequestBody CurrencyExchangeRequest currencyExchangeRequest) {
        currencyExchangeService.currencyExchange(idUser, currencyExchangeRequest);
    }
}
