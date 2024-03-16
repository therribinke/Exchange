package com.example.demo.controller;



import com.example.demo.Converter.UserConverter;
import com.example.demo.dao.model.User;
import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserResponse;
import com.example.demo.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<UserResponse> getAllUsers() {
        return UserConverter.userCollectionConvertToList(userService.getUsers());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public UserResponse addUser(@RequestBody UserRequest userRequest) {
        User addUser = userService.saveUser(UserConverter.userRequestConvertToUser(userRequest));
        return UserConverter.userConvertToUserResponse(addUser);
    }

    @PutMapping(value = "/{id}",consumes = APPLICATION_JSON_VALUE,produces = APPLICATION_JSON_VALUE)
    public UserResponse updateUser(@PathVariable Integer id, @RequestBody UserRequest userRequest){
        User updateUser = userService.updateUser(id,UserConverter.userRequestConvertToUser(userRequest));
        return UserConverter.userConvertToUserResponse(updateUser);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}",produces = APPLICATION_JSON_VALUE)
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }


}





