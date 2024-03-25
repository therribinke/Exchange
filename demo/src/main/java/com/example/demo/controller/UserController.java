package com.example.demo.controller;



import com.example.demo.Converter.UserConverter;
import com.example.demo.dao.model.UserData;
import com.example.demo.dto.request.UserDataRequest;
import com.example.demo.dto.response.UserDataResponse;
import com.example.demo.service.UserDataService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class UserController {
    private final UserDataService userDataService;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<UserDataResponse> getAllUsers() {
        return UserConverter.userCollectionConvertToList(userDataService.getUsers());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public UserDataResponse addUser(@RequestBody UserDataRequest userDataRequest) {
        UserData addUserData = userDataService.saveUser(UserConverter.userRequestConvertToUser(userDataRequest));
        return UserConverter.userConvertToUserResponse(addUserData);
    }

    @PutMapping(value = "/{id}",consumes = APPLICATION_JSON_VALUE,produces = APPLICATION_JSON_VALUE)
    public UserDataResponse updateUser(@PathVariable Long id, @RequestBody UserDataRequest userDataRequest){
        UserData updateUserData = userDataService.updateUser(id,UserConverter.userRequestConvertToUser(userDataRequest));
        return UserConverter.userConvertToUserResponse(updateUserData);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}",produces = APPLICATION_JSON_VALUE)
    public void deleteUser(@PathVariable Long id){
        userDataService.deleteUser(id);
    }


}





