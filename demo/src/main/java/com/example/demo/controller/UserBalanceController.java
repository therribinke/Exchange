package com.example.demo.controller;

import com.example.demo.Converter.UserBalanceConverter;
import com.example.demo.dao.model.UserBalance;
import com.example.demo.dto.UserBalanceRequest;
import com.example.demo.dto.UserBalanceResponse;
import com.example.demo.service.UserBalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/userbalance")
public class UserBalanceController {
    private final UserBalanceService userBalanceService;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<UserBalanceResponse> getAllUserBalance() {
        return UserBalanceConverter.userBalanceCollectionToList(userBalanceService.getAllUserBalance());
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public UserBalanceResponse getUserBalance(@PathVariable Long id) {
        return UserBalanceConverter.userBalanceConvertToUserBalanceResponse(userBalanceService.getUserBalance(id));
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public UserBalanceResponse addUserBalance(@RequestBody UserBalanceRequest userBalanceRequest) {
        UserBalance userBalance = userBalanceService.saveUserBalance
                (UserBalanceConverter.userBalanceRequestConvertToUserBalance(userBalanceRequest));
        return UserBalanceConverter.userBalanceConvertToUserBalanceResponse(userBalance);
    }

    @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public UserBalanceResponse updateUserBalance(@PathVariable Long id,
                                                 @RequestBody UserBalanceRequest userBalanceRequest) {
        UserBalance userBalance = userBalanceService.updateUserBalance
                (id, UserBalanceConverter.userBalanceRequestConvertToUserBalance(userBalanceRequest));
        return UserBalanceConverter.userBalanceConvertToUserBalanceResponse(userBalance);
    }
    @DeleteMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public void deleteUserBalance(@PathVariable Long id){
        userBalanceService.deleteUserBalance(id);
    }

}
