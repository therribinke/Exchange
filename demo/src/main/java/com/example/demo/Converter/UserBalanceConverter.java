package com.example.demo.Converter;

import com.example.demo.dao.model.UserBalance;
import com.example.demo.dto.request.UserBalanceRequest;
import com.example.demo.dto.response.UserBalanceResponse;
import lombok.experimental.UtilityClass;

import java.util.Collection;
import java.util.List;

@UtilityClass
public class UserBalanceConverter {

    public static UserBalance userBalanceRequestConvertToUserBalance(UserBalanceRequest userBalanceRequest,Long titleId) {
        return new UserBalance()
                .setTitleId(titleId)
                .setValue(userBalanceRequest.getValue());
    }

    public static UserBalanceResponse userBalanceConvertToUserBalanceResponse(UserBalance userBalance) {
        return UserBalanceResponse.builder()
                .id(userBalance.getId())
                .titleId(userBalance.getTitleId())
                .value(userBalance.getValue())
                .build();
    }

    public static List<UserBalanceResponse> userBalanceCollectionToList(Collection<UserBalance> collection){
        return collection.stream().map(UserBalanceConverter::userBalanceConvertToUserBalanceResponse).toList();
    }
}
