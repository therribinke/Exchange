package com.example.demo.controller;

import com.example.demo.dao.model.*;
import com.example.demo.dto.request.CurrencyExchangeRequest;
import com.example.demo.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/balance")
public class CurrencyExchangeController {
    private final UserBalanceService userBalanceService;
    private final UserDataService userDataService;
    private final CurrencyService currencyService;
    private final ExchangeService exchangeService;
    private final ExchangeValueService exchangeValueService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/user/{idUser}/currencyexchange", consumes = APPLICATION_JSON_VALUE)
    public void exchangeUserValue(@PathVariable Long idUser,
                                  @RequestBody CurrencyExchangeRequest currencyExchangeRequest) {
        var user = userDataService.getUser(idUser);
        List<Long> list = user.getBalance();
        Long currencySellId = currencyService.getValueNameByValueName
                (currencyExchangeRequest.getValueNameSell()).getId();
        Long currencyBuyId = currencyService.getValueNameByValueName
                (currencyExchangeRequest.getValueNameBuy()).getId();
        Exchange exchangeName = exchangeService.getExchangeByExchangeName(currencyExchangeRequest.getExchangename());
        Float valueSell = exchangeValueService.getExchangeValueByValueNames
                (exchangeName.getId(), currencySellId, currencyBuyId).getValueGive();
        Float valueBuy = exchangeValueService.getExchangeValueByValueNames
                (exchangeName.getId(), currencySellId, currencyBuyId).getValueReceive();
        List<Long> userBalanceId = userBalanceService.getUserBalanceIdOrException
                (currencySellId, currencyBuyId, list, idUser);
        UserBalance userBalanceSell = userBalanceService.getUserBalance(userBalanceId.get(0));
        userBalanceSell.setValue(userBalanceSell.getValue() - currencyExchangeRequest.getValueSell());
        userBalanceService.updateUserBalance(userBalanceId.get(0), userBalanceSell);
        UserBalance userBalanceBuy = userBalanceService.getUserBalance(userBalanceId.get(1));
        userBalanceBuy.setValue
                (userBalanceBuy.getValue() + currencyExchangeRequest.getValueSell() / valueBuy * valueSell);
        userBalanceService.updateUserBalance(userBalanceId.get(1), userBalanceBuy);
    }
}
