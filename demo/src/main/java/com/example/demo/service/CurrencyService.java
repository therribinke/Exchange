package com.example.demo.service;

import com.example.demo.dao.model.Currency;
import com.example.demo.dao.repos.CurrencyRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@AllArgsConstructor
public class CurrencyService {

    private final CurrencyRepo currencyRepo;
    @Transactional
    public List<Currency> getValueNames(){
        return currencyRepo.findAll();
    }
    @Transactional
    public Currency getValueName(Long id){
        return currencyRepo.getReferenceById(id);
    }

    @Transactional
    public Currency getValueNameByValueName(String title){
        List<Currency> list = currencyRepo.findByTitleLike(title);
        return list.getFirst();
    }

    @Transactional
    public Currency saveValueName(Currency currencyRequest){
        return currencyRepo.save(currencyRequest);
    }

    @Transactional
    public Currency updateValueName(Long id, Currency currencyRequest){
        if(currencyRepo.existsById(id)){
            currencyRequest.setId(id);
            return currencyRepo.save(currencyRequest);
        }
        throw new EntityNotFoundException("Currency with id = %s not found".formatted(id));
    }

    @Transactional
    public void deleteValueNames (Long id){
        currencyRepo.deleteById(id);
    }
}
