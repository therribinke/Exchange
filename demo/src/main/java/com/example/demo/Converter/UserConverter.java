package com.example.demo.Converter;

import com.example.demo.dao.model.User;
import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserResponse;
import lombok.experimental.UtilityClass;

import java.util.Collection;
import java.util.List;
@UtilityClass
public class UserConverter {
    public static User userRequestConvertToUser(UserRequest userRequest) {
        return new User().setLogin(userRequest.getLogin())
                .setPassword(userRequest.getPassword())
                .setEmail(userRequest.getEmail());
    }

    public static UserResponse userConvertToUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .login(user.getLogin())
                .password(user.getPassword())
                .email(user.getEmail())
                .build();
    }
    public static List<UserResponse> userCollectionConvertToList(Collection<User> userCollection) {
        return userCollection.stream().map(UserConverter::userConvertToUserResponse).toList();
    }
}
