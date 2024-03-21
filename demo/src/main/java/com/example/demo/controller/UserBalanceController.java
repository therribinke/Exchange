package com.example.demo.controller;

import com.example.demo.Converter.UserBalanceConverter;
import com.example.demo.dao.model.User;
import com.example.demo.dao.model.UserBalance;
import com.example.demo.dao.model.ValueNames;
import com.example.demo.dto.UserBalanceRequest;
import com.example.demo.dto.UserBalanceResponse;
import com.example.demo.service.UserBalanceService;
import com.example.demo.service.UserService;
import com.example.demo.service.ValueNamesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/balance")
public class UserBalanceController {
    private final UserBalanceService userBalanceService;
    private final UserService userService;
    private final ValueNamesService valueNamesService;

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
        ValueNames valueNames = valueNamesService.getValueNameByValueName(userBalanceRequest.getValuename());
        User user = userService.getUser(id);
        UserBalance userBalance = userBalanceService.saveUserBalance
                (UserBalanceConverter.userBalanceRequestConvertToUserBalance(userBalanceRequest,valueNames.getId()));
        userBalanceService.updateUserBalance(id,userBalance.getId(),user);
        return UserBalanceConverter.userBalanceConvertToUserBalanceResponse(userBalance);
    }

    @PutMapping(value = "/user/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public UserBalanceResponse updateUserBalance(@PathVariable Long id,
                                                 @RequestBody UserBalanceRequest userBalanceRequest) {
        ValueNames valueNames = valueNamesService.getValueNameByValueName(userBalanceRequest.getValuename());
        UserBalance userBalance = userBalanceService.updateUserBalance
                (id, UserBalanceConverter.userBalanceRequestConvertToUserBalance(userBalanceRequest,valueNames.getId()));
        return UserBalanceConverter.userBalanceConvertToUserBalanceResponse(userBalance);
    }
    @DeleteMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public void deleteUserBalance(@PathVariable Long id){
        userBalanceService.deleteUserBalance(id);
    }

}
