package com.example.demo.service;

import com.example.demo.dao.repos.UserRepo;
import com.example.demo.dao.model.User;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    @Transactional
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @Transactional
    public User saveUser(User userRequest) {
        return userRepo.save(userRequest);
    }

    @Transactional
    public User updateUser(Long id, User userRequest) {
        if (userRepo.existsById(id)) {
            userRequest.setId(id);
            return userRepo.save(userRequest);
        }
        throw new EntityNotFoundException("User with id = %s not found".formatted(id));
    }

    @Transactional
    public void deleteUser(Long id) {
           userRepo.deleteById(id);
    }

}

