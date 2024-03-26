package com.example.demo.service;

import com.example.demo.dao.model.UserData;
import com.example.demo.dao.repos.UserDataRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDataService {

    private final UserDataRepo userDataRepo;

    @Transactional
    public List<UserData> getUsers() {
        return userDataRepo.findAll();
    }

    @Transactional
    public UserData getUser(Long id) {
        return userDataRepo.getReferenceById(id);
    }
    @Transactional
    public UserData saveUser(UserData userDataRequest) {
        return userDataRepo.save(userDataRequest);
    }

    @Transactional
    public UserData updateUser(Long id, UserData userDataRequest) {
        if (userDataRepo.existsById(id)) {
            userDataRequest.setId(id);
            return userDataRepo.save(userDataRequest);
        }
        throw new EntityNotFoundException("UserData with id = %s not found".formatted(id));
    }

    @Transactional
    public void deleteUser(Long id) {
           userDataRepo.deleteById(id);
    }

}

