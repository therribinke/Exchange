/*
package com.example.demo.service;

import com.example.demo.dao.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private List<User> users = new ArrayList<>();
    private long ID=0;

    public List<User> listUsers(){
        return users;
    }
    public void saveUser(User user){

    }
    public void deleteUser(Long id){
        users.removeIf(user -> user.getId().equals(id) );
    }
    public User getUserByID(Long id){
       for (User user : users){
           if(user.getId()==id){
               return user;
           }
       }
       return null;
    }
    public boolean checkSameLogin(String login){
        for (User user : users){
            if (user.getLogin().equals(login)){
                return true;
            }
        }
        return false;
    }

    public String getPasswordByLogin(String Login){
        for (User user : users){
            if(user.getLogin().equals(Login)){
                return user.getPassword();
            }
        }
        return "";
    }
    public Long getIDByLogin(String Login){
        for (User user : users){
            if(user.getLogin().equals(Login)){
                return user.getId();
            }
        }
        return null;
    }
}
*/
