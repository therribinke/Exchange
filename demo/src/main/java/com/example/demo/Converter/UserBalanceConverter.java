package com.example.demo.Converter;

import com.example.demo.dao.model.UserBalance;
import com.example.demo.dto.UserBalanceRequest;
import com.example.demo.dto.UserBalanceResponse;
import lombok.experimental.UtilityClass;

import java.util.Collection;
import java.util.List;

@UtilityClass
public class UserBalanceConverter {

    public static UserBalance userBalanceRequestConvertToUserBalance(UserBalanceRequest userBalanceRequest) {
        return new UserBalance()
                .setValuename(userBalanceRequest.getValuename())
                .setValue(userBalanceRequest.getValue());
    }

    public static UserBalanceResponse userBalanceConvertToUserBalanceResponse(UserBalance userBalance) {
        return UserBalanceResponse.builder()
                .id(userBalance.getId())
                .valuename(userBalance.getValuename())
                .value(userBalance.getValue())
                .build();
    }

    public static List<UserBalanceResponse> userBalanceCollectionToList(Collection<UserBalance> collection){
        return collection.stream().map(UserBalanceConverter::userBalanceConvertToUserBalanceResponse).toList();
    }
}
