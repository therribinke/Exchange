package com.example.demo.service;

import com.example.demo.dao.model.Exchange;
import com.example.demo.dao.model.UserBalance;
import com.example.demo.dto.request.CurrencyExchangeRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyExchangeService {
    private final UserDataService userDataService;
    private final CurrencyService currencyService;
    private final ExchangeService exchangeService;
    private final ExchangeValueService exchangeValueService;
    private final UserBalanceService userBalanceService;


    public void currencyExchange(Long idUser, CurrencyExchangeRequest currencyExchangeRequest) {
        if(currencyExchangeRequest.getValueSell()<=0){
            throw new ArithmeticException("Incorrect data entry");
        }
        var user = userDataService.getUser(idUser);
        List<Long> list = user.getBalance();
        Long currencySellId = currencyService.getValueNameByValueName
                (currencyExchangeRequest.getValueNameSell()).getId();
        Long currencyBuyId = currencyService.getValueNameByValueName
                (currencyExchangeRequest.getValueNameBuy()).getId();
        Exchange exchangeName = exchangeService.getExchangeByExchangeName(currencyExchangeRequest.getExchangename());
        var value = exchangeValueService.getExchangeValueByValueNames
                (exchangeName.getId(), currencySellId, currencyBuyId);
        List<Long> userBalanceId = userBalanceService.getUserBalanceIdOrException
                (currencySellId, currencyBuyId, list, idUser);
        if (userBalanceService.getUserBalance(userBalanceId.get(0)).getValue() < currencyExchangeRequest.getValueSell()
        | userBalanceService.getUserBalance(userBalanceId.get(0)).getValue() == 0 ){
            String currency = currencyService.getValueName(currencySellId).getLetters();
            throw new ArithmeticException("Your %s balance is less than what you want to exchange".formatted(currency));
        }

            UserBalance userBalanceSell = userBalanceService.getUserBalance(userBalanceId.get(0));
        userBalanceSell.setValue(userBalanceSell.getValue() - currencyExchangeRequest.getValueSell());
        userBalanceService.updateUserBalance(userBalanceId.get(0), userBalanceSell);
        UserBalance userBalanceBuy = userBalanceService.getUserBalance(userBalanceId.get(1));
        userBalanceBuy.setValue
                (userBalanceBuy.getValue() + currencyExchangeRequest.getValueSell()
                        * value.getValueReceive() / value.getValueGive());
        userBalanceService.updateUserBalance(userBalanceId.get(1), userBalanceBuy);
    }

}
