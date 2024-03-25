package com.example.demo.controller;

import com.example.demo.Converter.UserBalanceConverter;
import com.example.demo.dao.model.Currency;
import com.example.demo.dao.model.UserData;
import com.example.demo.dao.model.UserBalance;
import com.example.demo.dto.request.UserBalanceRequest;
import com.example.demo.dto.response.UserBalanceResponse;
import com.example.demo.service.UserBalanceService;
import com.example.demo.service.UserDataService;
import com.example.demo.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/balance")
public class UserBalanceController {
    private final UserBalanceService userBalanceService;
    private final UserDataService userDataService;
    private final CurrencyService currencyService;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<UserBalanceResponse> getAllUserBalance() {
        return UserBalanceConverter.userBalanceCollectionToList(userBalanceService.getAllUserBalance());
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public UserBalanceResponse getUserBalance(@PathVariable Long id) {
        return UserBalanceConverter.userBalanceConvertToUserBalanceResponse(userBalanceService.getUserBalance(id));
    }

    @PostMapping(value = "/user/{id}",consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public UserBalanceResponse addUserBalance(@PathVariable Long id,
                                              @RequestBody UserBalanceRequest userBalanceRequest) {
        Currency currency = currencyService.getValueNameByValueName(userBalanceRequest.getTitle());
        UserData userData = userDataService.getUser(id);
        UserBalance userBalance = userBalanceService.saveUserBalance
                (UserBalanceConverter.userBalanceRequestConvertToUserBalance(userBalanceRequest, currency.getId()));
        userBalanceService.updateUserBalance(id,userBalance.getId(), userData);
        return UserBalanceConverter.userBalanceConvertToUserBalanceResponse(userBalance);
    }

    /*@ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/user/{id}/{valueNameSell}/{valueNameBuy}/{valueSell}",produces = APPLICATION_JSON_VALUE)
    public void exchangeUserValue(@PathVariable Long idUser, @PathVariable String valueNameSell,
                                                 @PathVariable String valueNameBuy, @PathVariable Float valueSell){
        UserData user = userDataService.getUser(idUser);

    }*/


    @PutMapping(value = "/user/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public UserBalanceResponse updateUserBalance(@PathVariable Long id,
                                                 @RequestBody UserBalanceRequest userBalanceRequest) {
        Currency currency = currencyService.getValueNameByValueName(userBalanceRequest.getTitle());
        UserBalance userBalance = userBalanceService.updateUserBalance
                (id, UserBalanceConverter.userBalanceRequestConvertToUserBalance(userBalanceRequest, currency.getId()));
        return UserBalanceConverter.userBalanceConvertToUserBalanceResponse(userBalance);
    }
    @DeleteMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public void deleteUserBalance(@PathVariable Long id){
        userBalanceService.deleteUserBalance(id);
    }

}
