package com.example.demo.Converter;

import com.example.demo.dao.model.UserData;
import com.example.demo.dto.request.UserDataRequest;
import com.example.demo.dto.response.UserDataResponse;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@UtilityClass
public class UserConverter {
    public static UserData userRequestConvertToUser(UserDataRequest userDataRequest) {
        return new UserData().setLogin(userDataRequest.getLogin())
                .setPassword(userDataRequest.getPassword())
                .setEmail(userDataRequest.getEmail());
    }
    public static UserData userConvertToUser(Long id, UserData userData) {
        if(userData.getBalance()==null) {
        userData.setBalance(new ArrayList<>());
        }
        List<Long> list = userData.getBalance();
        list.addLast(id);
        return new UserData().setLogin(userData.getLogin())
                .setPassword(userData.getPassword())
                .setEmail(userData.getEmail())
                .setBalance(list);
    }

    public static UserDataResponse userConvertToUserResponse(UserData userData) {
        return UserDataResponse.builder()
                .id(userData.getId())
                .login(userData.getLogin())
                .password(userData.getPassword())
                .email(userData.getEmail())
                .build();
    }
    public static List<UserDataResponse> userCollectionConvertToList(Collection<UserData> userDataCollection) {
        return userDataCollection.stream().map(UserConverter::userConvertToUserResponse).toList();
    }
}
