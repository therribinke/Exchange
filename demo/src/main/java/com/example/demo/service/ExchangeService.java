package com.example.demo.service;

import com.example.demo.dao.ExchangeRepo;
import com.example.demo.dao.model.Exchange;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExchangeService {

    private final ExchangeRepo exchangeRepo;

    @Transactional
    public List<Exchange> getExchanges(){
        return exchangeRepo.findAll();
    }
    @Transactional
    public Exchange saveExchange(Exchange exchangeRequest){
        return exchangeRepo.save(exchangeRequest);
    }

    @Transactional
    public Exchange updateExchange(Integer id,Exchange exchangeRequest){
        if (exchangeRepo.existsById(id)) {
            exchangeRequest.setId(id);
            return exchangeRepo.save(exchangeRequest);
        }
        throw new EntityNotFoundException("Exchange with id = %s not found".formatted(id));
    }

    @Transactional
    public void deleteExchange(Integer id){
        exchangeRepo.deleteById(id);
    }

}
