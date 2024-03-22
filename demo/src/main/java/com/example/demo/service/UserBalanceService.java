package com.example.demo.service;

import com.example.demo.Converter.UserConverter;
import com.example.demo.dao.model.User;
import com.example.demo.dao.model.UserBalance;
import com.example.demo.dao.repos.UserBalanceRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserBalanceService {
    private final UserBalanceRepo userBalanceRepo;
    private final UserService userService;

    @Transactional
    public List<UserBalance> getAllUserBalance() {
        return userBalanceRepo.findAll();
    }

    @Transactional
    public UserBalance getUserBalance(Long id) {
        return userBalanceRepo.getReferenceById(id);
    }

    @Transactional
    public UserBalance saveUserBalance(UserBalance userBalanceRequest) {
        return userBalanceRepo.save(userBalanceRequest);
    }


    public void updateUserBalance( Long idUser, Long idBalance, User user){
        User updateUserBalance = UserConverter.userConvertToUser(idBalance,user);
        userService.updateUser(idUser, updateUserBalance);
    }

    @Transactional
    public UserBalance updateUserBalance(Long id, UserBalance userBalanceRequest) {
        if (userBalanceRepo.existsById(id)) {
            userBalanceRequest.setId(id);
            return userBalanceRepo.save(userBalanceRequest);
        }
        throw new EntityNotFoundException("UserBalance with id = %s not found".formatted(id));
    }

    @Transactional
    public void deleteUserBalance(Long id){
        userBalanceRepo.deleteById(id);
    }
}
