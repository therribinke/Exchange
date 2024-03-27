package com.example.demo.service;

import com.example.demo.Converter.UserConverter;
import com.example.demo.dao.model.UserBalance;
import com.example.demo.dao.model.UserData;
import com.example.demo.dao.repos.UserBalanceRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserBalanceService {
    private final UserBalanceRepo userBalanceRepo;
    private final UserDataService userDataService;

    @Transactional
    public List<UserBalance> getAllUserBalance() {
        return userBalanceRepo.findAll();
    }

    @Transactional
    public UserBalance getUserBalance(Long id) {
        return userBalanceRepo.getReferenceById(id);
    }

    @Transactional
    public UserBalance getUserBalanceByTitleId(Long id) {
        List<UserBalance> list = userBalanceRepo.findByTitleId(id);
        return list.getFirst();
    }

    @Transactional
    public UserBalance saveUserBalance(UserBalance userBalanceRequest) {
        return userBalanceRepo.save(userBalanceRequest);
    }


    public void updateUserBalance(Long idUser, Long idBalance, UserData userData) {
        UserData updateUserBalanceData = UserConverter.userConvertToUser(idBalance, userData);
        userDataService.updateUser(idUser, updateUserBalanceData);
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
    public void deleteUserBalance(Long id) {
        userBalanceRepo.deleteById(id);
    }


    public List<Long> getUserBalanceIdOrException(Long currencySellId, Long currencyBuyId, List<Long> list,
                                                  Long idUser) {
        List<Long> result = getUserBalanceIdForTheExchange(currencySellId, currencyBuyId, list);

        if (result.get(0) == (null)) {
            saveUserBalance(new UserBalance().setTitleId(currencySellId).setValue(0F));
            updateUserBalance(idUser, getUserBalanceByTitleId(currencySellId).getId(), userDataService.getUser(idUser));
            result.set(0, getUserBalanceByTitleId(currencySellId).getId());
        } else if (result.get(1) == (null)) {
            saveUserBalance(new UserBalance().setTitleId(currencyBuyId).setValue(0F));
            updateUserBalance(idUser, getUserBalanceByTitleId(currencyBuyId).getId(), userDataService.getUser(idUser));
            result.set(1, getUserBalanceByTitleId(currencyBuyId).getId());
        }
        return result;
    }

    public List<Long> getUserBalanceIdForTheExchange(Long currencySellId, Long currencyBuyId, List<Long> list) {
        List<Long> result = new ArrayList<>();
        result.add(null);
        result.add(null);
        Long id = 0L;
        for (Long i : list) {
            id = getUserBalance(i).getTitleId();
            if (currencySellId.equals(id)) {
                result.set(0, getUserBalance(i).getId());
            } else if (currencyBuyId.equals(id)) {
                result.set(1, getUserBalance(i).getId());
            }
        }
        return result;
    }
}
