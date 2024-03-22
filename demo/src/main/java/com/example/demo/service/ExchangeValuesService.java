package com.example.demo.service;

import com.example.demo.dao.model.ExchangesValues;
import com.example.demo.dao.repos.ExchangeValuesRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExchangeValuesService {
    private final ExchangeValuesRepo exchangeValuesRepo;

    @Transactional
    public List<ExchangesValues> getAllExchangeValues() {
        return exchangeValuesRepo.findAll();
    }

    @Transactional
    public ExchangesValues getExchangeValue(Long id) {
        return exchangeValuesRepo.getReferenceById(id);
    }

    @Transactional
    public ExchangesValues getExchangeValueByValueNames(String string,Long name1, Long name2) {
        List<ExchangesValues> list = exchangeValuesRepo.findByExchangenameLikeAndValuename1AndValuename2
                (string,name1, name2);
        return list.getFirst();
    }

    @Transactional
    public ExchangesValues saveExchangeValue(ExchangesValues exchangesValuesRequest) {
        return exchangeValuesRepo.save(exchangesValuesRequest);
    }

    @Transactional
    public ExchangesValues updateExchangeValue(Long id, ExchangesValues exchangesValuesRequest) {
        if (exchangeValuesRepo.existsById(id)) {
            exchangesValuesRequest.setId(id);
            return exchangeValuesRepo.save(exchangesValuesRequest);
        }
        throw new EntityNotFoundException("ExchangeValue with id = %s not found".formatted(id));
    }

    @Transactional
    public void deleteExchangeValue(Long id) {
        exchangeValuesRepo.deleteById(id);
    }
}
